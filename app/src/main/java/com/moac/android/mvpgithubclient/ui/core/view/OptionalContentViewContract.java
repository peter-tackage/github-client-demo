package com.moac.android.mvpgithubclient.ui.core.view;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public interface OptionalContentViewContract<T> extends ContentViewContract<T> {
    void showEmpty();
}
