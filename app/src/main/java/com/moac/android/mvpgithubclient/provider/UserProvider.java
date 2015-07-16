package com.moac.android.mvpgithubclient.provider;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.GithubApi;
import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.util.Preconditions;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class UserProvider {
    @NonNull private final GithubApi githubApi;

    public UserProvider(@NonNull GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @NonNull
    public Observable<User> getUser(@NonNull String username) {
        Preconditions.checkNotNullOrEmpty(username, "Parameter username cannot be null or empty.");
        return githubApi.getUser(username);
    }

}
