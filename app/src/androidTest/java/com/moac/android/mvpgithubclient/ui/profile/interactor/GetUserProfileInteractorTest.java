package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Peter Tackage
 * @since 13/07/15
 * <p/>
 * Android dependent test for UserModelInteractorImpl.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class GetUserProfileInteractorTest extends PatchedDexmakerTestCase {

    @Test
    public void testObservedOnMainThread_WhenNoSchedulerProvided() throws Exception {

        UserProvider userProvider = mock(UserProvider.class);
        when(userProvider.getUser(any(String.class))).thenReturn(Observable.<User>empty());

        // Observe via the AndroidScheduler's main thread
        GetUserByNameInteractor userModelInteractor = new GetUserByNameInteractor(userProvider);

        TestEventSubscriber<ProfileViewModel> subscriber = new TestEventSubscriber<>();
        userModelInteractor.call(any(String.class)).subscribe(subscriber);

        subscriber.assertObservedOnAndroidMainThread();

    }
}
