package com.moac.android.mvpgithubclient.ui.search.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public interface SearchQueryViewContract {

    @NonNull
    Observable<String> getSearchQuery();

    void setSearchView(@NonNull SearchView searchView);
}
