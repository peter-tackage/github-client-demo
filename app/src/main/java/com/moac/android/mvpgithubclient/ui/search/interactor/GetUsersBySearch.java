package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.model.UserSearchResult;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public interface GetUsersBySearch {

    @NonNull
    Observable<UserSearchResult> call(@NonNull String searchTerm);
}
