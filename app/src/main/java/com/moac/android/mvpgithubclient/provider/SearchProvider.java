package com.moac.android.mvpgithubclient.provider;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.GithubApi;
import com.moac.android.mvpgithubclient.api.model.Order;
import com.moac.android.mvpgithubclient.api.model.Sort;
import com.moac.android.mvpgithubclient.api.model.UserSearchResult;
import com.moac.android.mvpgithubclient.util.Preconditions;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class SearchProvider {
    @NonNull private final GithubApi githubApi;

    public SearchProvider(@NonNull GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @NonNull
    public Observable<UserSearchResult> searchUsers(@NonNull String query) {
        Preconditions.checkNotNullOrEmpty(query, "Parameter 'query' cannot be null or empty.");
        return githubApi.searchUsers(query, Sort.FOLLOWERS, Order.DESCENDING);
    }
}
