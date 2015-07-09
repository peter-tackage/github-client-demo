package com.moac.android.mvpgithubclient.ui.core.view;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * @author Peter Tackage
 * @since 09/07/15
 */

public class SnackbarErrorRenderer implements ErrorRenderer {

    @Override
    public void showShortError(View anchorView, String msg) {
        Snackbar.make(anchorView, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLongError(View anchorView, String msg) {
        Snackbar.make(anchorView, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showStickyError(View anchorView, String msg) {
        // TODO Would require some sort of callback
    }

}
