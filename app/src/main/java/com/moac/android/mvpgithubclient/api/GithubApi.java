package com.moac.android.mvpgithubclient.api;

import com.moac.android.mvpgithubclient.api.model.Order;
import com.moac.android.mvpgithubclient.api.model.Sort;
import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.api.model.UserSearchResult;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author Peter Tackage
 * @since 04/07/15
 */
public interface GithubApi {

    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);

    /**
     * Refer https://developer.github.com/v3/search/#search-users
     */
    @GET("/search/users")
    Observable<UserSearchResult> searchUsers(@Query("q") String query,
                                             @Query("sort") Sort sortField,
                                             @Query("order") Order order);

}
