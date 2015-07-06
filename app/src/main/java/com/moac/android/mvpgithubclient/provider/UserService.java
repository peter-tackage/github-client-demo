package com.moac.android.mvpgithubclient.provider;

import com.moac.android.mvpgithubclient.api.GithubUserApi;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class UserService {

    private final GithubUserApi githubUserApi;

    public UserService(GithubUserApi githubUserApi) {
        this.githubUserApi = githubUserApi;
    }

}
