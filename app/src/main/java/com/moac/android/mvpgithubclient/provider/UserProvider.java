package com.moac.android.mvpgithubclient.provider;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.GithubUserApi;
import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.util.Preconditions;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class UserProvider {
    @NonNull private final GithubUserApi githubUserApi;

    public UserProvider(@NonNull GithubUserApi githubUserApi) {
        this.githubUserApi = githubUserApi;
    }

    @NonNull
    public Observable<User> getUser(@NonNull String username) {
        Preconditions.checkNotNullOrEmpty(username, "Parameter username cannot be null or empty.");

        return githubUserApi.getUser(username);
    }
}
