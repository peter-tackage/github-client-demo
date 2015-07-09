package com.moac.android.mvpgithubclient.ui.core.view;

import android.view.View;

/**
 * @author Peter Tackage
 * @since 09/07/15
 */
public interface ErrorRenderer {
    void showShortError(View anchorView, String msg);

    void showLongError(View anchorView, String msg);

    void showStickyError(View anchorView, String msg);
}
