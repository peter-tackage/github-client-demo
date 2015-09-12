package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.injection.module.SchedulerModule;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import rx.Observable;

import static com.moac.android.mvpgithubclient.test.asserts.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SmallTest
@RunWith(AndroidJUnit4.class)
public class GetUserProfileInteractorAndroidTest extends PatchedDexmakerTestCase {

    @Inject
    SchedulerProvider schedulerProvider;

    @Singleton
    @Component(modules = SchedulerModule.class)
    interface TestComponent {
        SchedulerProvider getSchedulerProvider();

        void inject(GetUserProfileInteractorAndroidTest test);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        DaggerGetUserProfileInteractorAndroidTest_TestComponent.create().inject(this);
    }

    @Test
    public void testObservedOnMainThread_WhenNoSchedulerProvided() throws Exception {

        // Empty Observable, as we are only testing the observation thread.
        UserProvider userProvider = mock(UserProvider.class);
        when(userProvider.getUser(any(String.class))).thenReturn(Observable.<User>empty());

        // Default constructor should create Observable that is observed on AndroidScheduler's main thread
        GetUserByNameInteractor userModelInteractor = new GetUserByNameInteractor(userProvider, schedulerProvider);

        TestEventSubscriber<ProfileViewModel> subscriber = new TestEventSubscriber<>();
        userModelInteractor.call(any(String.class)).subscribe(subscriber);

        subscriber.awaitTerminalEvent(5, TimeUnit.SECONDS);

        assertThat(subscriber).wasObservedOnAndroidMainThread();
    }
}
