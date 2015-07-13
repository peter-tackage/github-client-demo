package com.moac.android.mvpgithubclient.ui.core.view;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author Peter Tackage
 * @since 09/07/15
 */
public interface ErrorRenderer {
    void showShortError(@NonNull View anchorView, @NonNull String msg);

    void showLongError(@NonNull View anchorView, @NonNull String msg);

    void showStickyError(@NonNull View anchorView, @NonNull String msg);
}
