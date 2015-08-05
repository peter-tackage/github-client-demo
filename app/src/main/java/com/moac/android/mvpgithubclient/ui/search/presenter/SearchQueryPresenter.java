package com.moac.android.mvpgithubclient.ui.search.presenter;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public interface SearchQueryPresenter {

    void bindView(@NonNull SearchQueryViewContract searchQueryViewContract);

    void unbindView();
}
