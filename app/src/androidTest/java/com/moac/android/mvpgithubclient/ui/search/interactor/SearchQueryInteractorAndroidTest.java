package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.injection.module.SchedulerModule;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

import static com.moac.android.mvpgithubclient.test.asserts.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 13/07/15
 * <p/>
 * Android dependent test for SearchQueryInteractorImpl. Tests observation on Android main thread.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class SearchQueryInteractorAndroidTest extends PatchedDexmakerTestCase {

    @Inject
    SchedulerProvider schedulerProvider;

    @Singleton
    @Component(modules = SchedulerModule.class)
    interface TestComponent {
        SchedulerProvider getSchedulerProvider();

        void inject(SearchQueryInteractorAndroidTest test);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        DaggerSearchQueryInteractorAndroidTest_TestComponent.create().inject(this);
    }

    @Test
    public void testGetSearchQuery_IsObservedOnMainThread() throws Exception {

        // Use default value to produce event.
        SearchQueryInteractor searchQueryInteractor = new SearchQueryInteractorImpl(schedulerProvider);

        TestEventSubscriber<String> subscriber = new TestEventSubscriber<>();
        searchQueryInteractor.getSearchQuery().subscribe(subscriber);

        // Search query Observable never completes, only wait for first event.
        subscriber.awaitOnNextEvents(5, TimeUnit.SECONDS);

        assertThat(subscriber).wasObservedOnAndroidMainThread();

    }
}
