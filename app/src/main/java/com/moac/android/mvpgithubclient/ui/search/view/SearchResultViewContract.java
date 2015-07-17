package com.moac.android.mvpgithubclient.ui.search.view;

import com.moac.android.mvpgithubclient.api.model.UserSearchResult;
import com.moac.android.mvpgithubclient.ui.core.view.OptionalContentViewContract;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public interface SearchResultViewContract extends OptionalContentViewContract<UserSearchResult> {
    void showInitial();
}
