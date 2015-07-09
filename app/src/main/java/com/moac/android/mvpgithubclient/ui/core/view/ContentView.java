package com.moac.android.mvpgithubclient.ui.core.view;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public interface ContentView<T> {

    void showLoading();

    void showContent(T content);

    void showError(String msg);
}
