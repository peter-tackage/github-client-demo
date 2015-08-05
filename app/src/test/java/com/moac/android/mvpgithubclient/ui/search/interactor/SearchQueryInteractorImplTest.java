package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.SearchProvider;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserByNameInteractor;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
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
public class SearchQueryInteractorImplTest {

    private SearchQueryInteractor searchQueryInteractor;

    @Before
    public void before() {
        searchQueryInteractor = new SearchQueryInteractorImpl(Schedulers.immediate());
    }

    @After
    public void after() {
        searchQueryInteractor = null;
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(searchQueryInteractor).isNotNull();
    }

    @Test
    public void testDefaultSearchQuery_IsEmpty() {

        TestSubscriber<String> subscriber = new TestSubscriber<>();

        searchQueryInteractor.getSearchQuery().subscribe(subscriber);

        subscriber.assertNoErrors();
        assertThat(subscriber.isUnsubscribed()).isFalse();
        assertThat(subscriber.getOnNextEvents()).containsOnly("");
    }

    @Test
    public void testSearchQueryChangesFromDefault_WhenSet() {

        final String query = "dummy";

        TestSubscriber<String> subscriber = new TestSubscriber<>();

        searchQueryInteractor.getSearchQuery().subscribe(subscriber);
        searchQueryInteractor.setSearchQuery(query);

        subscriber.assertNoErrors();
        assertThat(subscriber.isUnsubscribed()).isFalse();
        assertThat(subscriber.getOnNextEvents()).containsSequence("", query);
    }

    @Test
    public void testSearchQuery_IsDistinctUntilChanged() {

        final String query = "dummy";
        final String query2 = "dummy2";

        TestSubscriber<String> subscriber = new TestSubscriber<>();

        searchQueryInteractor.getSearchQuery().subscribe(subscriber);
        searchQueryInteractor.setSearchQuery(query);
        searchQueryInteractor.setSearchQuery(query); // non-distinct, repeated value
        searchQueryInteractor.setSearchQuery(query2); // changed
        searchQueryInteractor.setSearchQuery(query); // changed

        subscriber.assertNoErrors();
        assertThat(subscriber.isUnsubscribed()).isFalse();
        assertThat(subscriber.getOnNextEvents()).containsSequence("", query, query2, query);
    }

}
