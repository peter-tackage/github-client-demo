package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.SearchProvider;
import com.moac.android.mvpgithubclient.util.Preconditions;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public class GetUsersBySearchInteractor implements GetUsersBySearch {

    @NonNull
    private final SearchProvider searchProvider;

    @Inject
    public GetUsersBySearchInteractor(@NonNull SearchProvider searchProvider) {
        this.searchProvider = searchProvider;
    }

    @NonNull
    @Override
    public Observable<List<User>> call(@NonNull String query) {
        Preconditions.checkNotNullOrEmpty(query, "Parameter 'query' cannot be null or empty");
        return searchProvider
                .searchUsers(query)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
