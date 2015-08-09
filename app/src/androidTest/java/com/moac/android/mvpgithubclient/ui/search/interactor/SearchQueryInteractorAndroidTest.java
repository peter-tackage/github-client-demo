package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

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

    @Test
    public void testObservedOnMainThread_WhenNoSchedulerProvided() throws Exception {

        SearchQueryInteractor searchQueryInteractor = new SearchQueryInteractorImpl();

        // Use default value to produce event; search query Observable never completes.
        TestEventSubscriber<String> subscriber = new TestEventSubscriber<>();
        searchQueryInteractor.getSearchQuery().subscribe(subscriber);

        subscriber.awaitOnNextEvents(5, TimeUnit.SECONDS);

        assertThat(subscriber).wasObservedOnAndroidMainThread();

    }
}
