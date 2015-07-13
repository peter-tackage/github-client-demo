package com.moac.android.mvpgithubclient.ui.core.view;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public interface ContentView<T> {

    void setContentView(@NonNull View view);

    void showLoading();

    void showContent(@NonNull T content);

    void showError(@NonNull String msg);
}
