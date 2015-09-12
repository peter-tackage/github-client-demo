package com.moac.android.mvpgithubclient.ui.profile.presenter;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserProfile;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;
import com.moac.android.mvpgithubclient.util.AndroidPreconditions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Observable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.powermock.api.mockito.PowerMockito.when;

@SmallTest
@PrepareForTest(AndroidPreconditions.class)
@RunWith(PowerMockRunner.class)
public class ProfilePresenterImplTest {

    @Mock
    GetUserProfile getUserProfile;

    @Mock
    ProfileViewContract profileView;

    private ProfilePresenterImpl profilePresenter;

    @Before
    public void before() {
        profilePresenter = new ProfilePresenterImpl(getUserProfile);
        // Ignore Android specific Preconditions
        PowerMockito.mockStatic(AndroidPreconditions.class);
    }

    @After
    public void after() {
        profilePresenter = null;
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(getUserProfile).isNotNull();
        assertThat(profileView).isNotNull();
        assertThat(profilePresenter).isNotNull();
    }

    @Test
    public void testSetsViewContent_WhenInteractorReturnsContent() {
        ProfileViewModel profileViewModel = mock(ProfileViewModel.class);
        when(getUserProfile.call(any(String.class)))
                .thenReturn(Observable.just(profileViewModel));

        profilePresenter.bindView(profileView);

        verify(profileView).showContent(profileViewModel);
    }

    @Test
    public void testSetsViewError_WhenInteractorReturnsError() {
        final String msg = "msg";
        Exception exception = mock(Exception.class);
        when(exception.getMessage()).thenReturn(msg);
        when(getUserProfile.call(any(String.class)))
                .thenReturn(Observable.<ProfileViewModel>error(exception));

        profilePresenter.bindView(profileView);

        verify(profileView).showError(msg);
    }

    @Test
    public void testNothingSet_WhenNoDataReturned() {
        when(getUserProfile.call(any(String.class)))
                .thenReturn(Observable.<ProfileViewModel>never());

        profilePresenter.bindView(profileView);

        verifyZeroInteractions(profileView);
    }

    @Test
    public void testNothingSet_WhenEmptyDataReturned() {
        when(getUserProfile.call(any(String.class)))
                .thenReturn(Observable.<ProfileViewModel>empty());

        profilePresenter.bindView(profileView);

        verifyZeroInteractions(profileView);
    }

    // TODO Test with other Exceptions once Presenter supports them

}
