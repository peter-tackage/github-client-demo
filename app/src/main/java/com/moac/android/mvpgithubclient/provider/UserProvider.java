package com.moac.android.mvpgithubclient.provider;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.GithubUserApi;
import com.moac.android.mvpgithubclient.api.model.User;

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
        return githubUserApi.getUser(username);
    }
}
