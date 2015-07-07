package com.moac.android.mvpgithubclient.provider;

import com.moac.android.mvpgithubclient.api.GithubUserApi;
import com.moac.android.mvpgithubclient.api.model.User;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class UserProvider {
    private final GithubUserApi githubUserApi;

    public UserProvider(GithubUserApi githubUserApi) {
        this.githubUserApi = githubUserApi;
    }

    public Observable<User> getUser(String username) {
        return githubUserApi.getUser(username);
    }
}
