package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public interface SearchQueryInteractor {
    void setSearchQuery(@NonNull String query);

    @NonNull
    Observable<String> getSearchQuery();
}
