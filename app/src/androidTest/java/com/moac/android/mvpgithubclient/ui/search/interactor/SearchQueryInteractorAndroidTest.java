package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

import org.junit.Test;
import org.junit.runner.RunWith;

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

        // Observe via the AndroidScheduler's main thread
        SearchQueryInteractor searchQueryInteractor = new SearchQueryInteractorImpl();

        TestEventSubscriber<String> subscriber = new TestEventSubscriber<>();
        searchQueryInteractor.getSearchQuery().subscribe(subscriber);

        subscriber.awaitEvents();

        subscriber.assertObservedOnAndroidMainThread();

    }
}
