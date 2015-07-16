package com.moac.android.mvpgithubclient.ui.core.view;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public interface OptionalContentListener<T> extends ContentListener<T> {
    void showEmpty();
}
