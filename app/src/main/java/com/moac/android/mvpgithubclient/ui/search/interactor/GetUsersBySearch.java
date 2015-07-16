package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.model.User;

import java.util.List;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public interface GetUsersBySearch {

    @NonNull
    Observable<List<User>> call(@NonNull String searchTerm);
}
