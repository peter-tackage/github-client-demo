package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
@RunWith(PowerMockRunner.class)
public class GetUserByNameInteractorTest {

    @Mock
    UserProvider userProvider;

    @Mock
    SchedulerProvider schedulerProvider;

    private GetUserByNameInteractor userModelInteractor;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        userModelInteractor = new GetUserByNameInteractor(userProvider, schedulerProvider);
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(userProvider).isNotNull();
        assertThat(userModelInteractor).isNotNull();
    }

}
