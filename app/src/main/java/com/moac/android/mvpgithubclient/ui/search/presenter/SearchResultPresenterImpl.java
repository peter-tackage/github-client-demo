package com.moac.android.mvpgithubclient.ui.search.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.moac.android.mvpgithubclient.api.model.UserSearchResult;
import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.search.interactor.GetUsersBySearch;
import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractor;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;
import com.moac.android.mvpgithubclient.util.TextUtils;

import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

import static com.moac.android.mvpgithubclient.util.RxUtils.unsubscribe;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public class SearchResultPresenterImpl implements SearchResultPresenter {

    private final GetUsersBySearch getUsersBySearch;
    private final SearchQueryInteractor searchQueryInteractor;
    private SearchResultViewContract searchResultViewContract;
    private Subscription subscription;

    public SearchResultPresenterImpl(GetUsersBySearch getUsersBySearch,
                                     SearchQueryInteractor searchQueryInteractor) {
        this.getUsersBySearch = getUsersBySearch;
        this.searchQueryInteractor = searchQueryInteractor;
    }

    @Override
    public void bindView(@NonNull SearchResultViewContract searchResultViewContract) {
        this.searchResultViewContract = searchResultViewContract;
        subscription = searchQueryInteractor.getSearchQuery().subscribe(new Action1<String>() {
            @Override
            public void call(String query) {
                setSearchQuery(query);
            }
        });
    }

    @Override
    public void unbindView() {
        unsubscribe(subscription);
        this.searchResultViewContract = null;
    }

    // TODO Should this be public or should everything be driven via the Interactor??
    public void setSearchQuery(@Nullable String query) {
        if (TextUtils.isNullOrEmpty(query)) return;

        subscription = getUsersBySearch.call(query)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        searchResultViewContract.showLoading();
                    }
                })
                .subscribe(new ContentObserver<UserSearchResult>() {

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        searchResultViewContract.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(UserSearchResult content) {
                        super.onNext(content);
                        searchResultViewContract.showContent(content);
                    }
                });
    }
}
