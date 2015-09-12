package com.moac.android.mvpgithubclient.ui.search.presenter;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractor;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;
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
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author Peter Tackage
 * @since 06/07/15
 * <p/>
 * Not too much to test as the SearchQueryPresenter is a router between the SearchQueryView and
 * whichever components are subscribed to the SearchQueryInteractor updates.
 * <p/>
 * TODO Once the SearchViewContract has a setSearchQuery(String) method, then this test should be
 * expanded to include that.
 */
@SmallTest
@RunWith(PowerMockRunner.class)
@PrepareForTest(AndroidPreconditions.class)
public class SearchQueryPresenterImplTest {

    @Mock
    SearchQueryInteractor searchQueryInteractor;

    @Mock
    SearchQueryViewContract searchQueryView;

    private SearchQueryPresenter searchQueryPresenter;

    @Before
    public void setUp() {
        searchQueryPresenter = new SearchQueryPresenterImpl(searchQueryInteractor);
        // Ignore Android specific Preconditions
        PowerMockito.mockStatic(AndroidPreconditions.class);
    }

    @After
    public void after() {
        searchQueryPresenter = null;
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(searchQueryInteractor).isNotNull();
        assertThat(searchQueryView).isNotNull();
        assertThat(searchQueryPresenter).isNotNull();
    }

    @Test
    public void testSetQueryString_WhenSearchViewQueryChanges() {
        final String dummyQuery = "dummyQuery";
        when(searchQueryView.getSearchQuery()).thenReturn(Observable.just(dummyQuery));

        searchQueryPresenter.bindView(searchQueryView);

        verify(searchQueryInteractor).setSearchQuery(dummyQuery);
    }

    @Test
    public void testSetQueryStringEmpty_WhenSearchViewQueryIsEmpty() {
        when(searchQueryView.getSearchQuery()).thenReturn(Observable.just(""));

        searchQueryPresenter.bindView(searchQueryView);

        verify(searchQueryInteractor).setSearchQuery("");
    }

    @Test
    public void testSetQueryStringNull_WhenSearchViewQueryIsNull() {
        when(searchQueryView.getSearchQuery()).thenReturn(Observable.just((String) null));

        searchQueryPresenter.bindView(searchQueryView);

        verify(searchQueryInteractor).setSearchQuery(null);
    }

}
