package com.moac.android.mvpgithubclient.ui.search.presenter;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractor;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;

import rx.Subscription;
import rx.functions.Action1;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public class SearchQueryPresenterImpl implements SearchQueryPresenter {

    private final SearchQueryInteractor searchQueryInteractor;
    private Subscription subscription;

    public SearchQueryPresenterImpl(SearchQueryInteractor searchQueryInteractor) {
        this.searchQueryInteractor = searchQueryInteractor;
    }

    @Override
    public void onViewCreated(@NonNull SearchQueryViewContract searchQueryViewContract) {
        subscription = searchQueryViewContract.getSearchQuery()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String query) {
                        searchQueryInteractor.setSearchQuery(query);
                    }
                });
    }

    @Override
    public void onViewDestroyed() {
        subscription.unsubscribe();
    }
}
