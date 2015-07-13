package com.moac.android.mvpgithubclient.ui.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractorImpl;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
@RunWith(PowerMockRunner.class)
public class UserModelInteractorImplTest {

    @Mock
    UserProvider userProvider;

    @Mock
    UserViewModelMapper userViewModelMapper;

    private UserModelInteractorImpl userModelInteractor;

    @Before
    public void before() {
        userModelInteractor = new UserModelInteractorImpl(userProvider, userViewModelMapper, Schedulers.immediate());
    }

    @After
    public void after() {
        userModelInteractor = null;
    }

    @Test
    public void testMapperIsInvoked_WhenSubscribed() {
        when(userProvider.getUser(any(String.class))).thenReturn(Observable.just(mock(User.class)));
        when(userViewModelMapper.call(any(User.class))).thenReturn(mock(ProfileViewModel.class));

        userModelInteractor.getProfileViewModel(any(String.class)).subscribe();

        verify(userViewModelMapper.call(any(User.class)));
    }

}
