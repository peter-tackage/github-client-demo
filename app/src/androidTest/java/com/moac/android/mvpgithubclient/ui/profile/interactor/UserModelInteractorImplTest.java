package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.test.core.PatchedAndroidTestCase;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.util.Preconditions;

import rx.Notification;
import rx.Observable;
import rx.functions.Action1;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
@SmallTest
public class UserModelInteractorImplTest extends PatchedAndroidTestCase {

    public void testObservedOnMainThread_WhenNoSchedulerProvided() throws Exception {
        UserProvider userProvider = mock(UserProvider.class);
        when(userProvider.getUser(any(String.class))).thenReturn(Observable.<User>empty());

        // Observe via the AndroidScheduler's main thread
        UserModelInteractorImpl userModelInteractor = new UserModelInteractorImpl(userProvider);

        userModelInteractor.getProfileViewModel(any(String.class))
                .materialize() // Force observation through single path
                .subscribe(new Action1<Notification<ProfileViewModel>>() {
                    @Override
                    public void call(Notification<ProfileViewModel> profileViewModelNotification) {
                        Preconditions.checkOnMainThread();
                    }
                });

    }
}
