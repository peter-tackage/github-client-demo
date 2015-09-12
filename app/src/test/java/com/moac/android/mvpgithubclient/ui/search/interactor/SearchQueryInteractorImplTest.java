package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.test.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
public class SearchQueryInteractorImplTest {

    private SearchQueryInteractor searchQueryInteractor;

    @Before
    public void setUp() {
        SchedulerProvider schedulerProvider = new TestSchedulerProvider.Builder().create();
        searchQueryInteractor = new SearchQueryInteractorImpl(schedulerProvider);
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
