package com.moac.android.mvpgithubclient.ui.core.view;

import android.view.View;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public interface ContentView<T> {

    void setContentView(View view);

    void showLoading();

    void showContent(T content);

    void showError(String msg);
}
