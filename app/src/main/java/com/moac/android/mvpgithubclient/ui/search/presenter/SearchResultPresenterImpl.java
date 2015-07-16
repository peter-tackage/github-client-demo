package com.moac.android.mvpgithubclient.ui.search.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.search.interactor.GetUsersBySearch;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;
import com.moac.android.mvpgithubclient.util.TextUtils;

import java.util.List;

import rx.Subscription;

import static com.moac.android.mvpgithubclient.util.RxUtils.unsubscribe;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public class SearchResultPresenterImpl implements SearchResultPresenter {

    private final GetUsersBySearch getUsersBySearch;
    private SearchResultViewContract searchResultViewContract;
    private Subscription subscription;

    public SearchResultPresenterImpl(GetUsersBySearch getUsersBySearch) {
        this.getUsersBySearch = getUsersBySearch;
    }

    public void setSearchQuery(@Nullable String query) {
        if (TextUtils.isNullOrEmpty(query)) return;

        subscription = getUsersBySearch.call(query)
                .subscribe(new ContentObserver<List<User>>() {

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        searchResultViewContract.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<User> content) {
                        super.onNext(content);
                        searchResultViewContract.showContent(content);
                    }
                });
    }

    @Override
    public void onViewCreated(@NonNull SearchResultViewContract searchResultViewContract) {
        this.searchResultViewContract = searchResultViewContract;
    }

    @Override
    public void onViewDestroyed() {
        unsubscribe(subscription);
        this.searchResultViewContract = null;
    }
}
