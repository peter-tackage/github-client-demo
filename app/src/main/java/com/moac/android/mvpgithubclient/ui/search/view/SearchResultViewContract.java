package com.moac.android.mvpgithubclient.ui.search.view;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.ui.core.view.OptionalContentViewContract;

import java.util.List;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public interface SearchResultViewContract extends OptionalContentViewContract<List<User>> {
    void showInitial();
}
