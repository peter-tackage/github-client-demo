package com.moac.android.mvpgithubclient.api;

import com.moac.android.mvpgithubclient.api.model.User;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * @author Peter Tackage
 * @since 04/07/15
 */
public interface GithubUserApi {

    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);

}
