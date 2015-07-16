package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class UserModelInteractorImplTest {

    @Mock
    UserProvider userProvider;

    @Mock
    UserViewModelMapper userViewModelMapper;

    private GetUserByNameInteractor userModelInteractor;

    @Before
    public void before() {
        userModelInteractor = new GetUserByNameInteractor(userProvider, userViewModelMapper, Schedulers.immediate());
    }

    @After
    public void after() {
        userModelInteractor = null;
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(userProvider).isNotNull();
        assertThat(userViewModelMapper).isNotNull();
        assertThat(userModelInteractor).isNotNull();
    }

    @Test
    public void testMapperIsInvoked_WhenSubscribed() {
        User user = mock(User.class);
        when(userProvider.getUser(any(String.class))).thenReturn(Observable.just(user));
        when(userViewModelMapper.call(any(User.class))).thenReturn(mock(ProfileViewModel.class));

        userModelInteractor.call("dummy").subscribe();

        verify(userViewModelMapper).call(user);
    }

}
