package com.moac.android.mvpgithubclient.util;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public final class ViewUtils {
    private ViewUtils() {
        //no instance
        throw new AssertionError("No instances allowed.");
    }

    @IdRes
    public static int getActivityRootViewId() {
        return android.R.id.content;
    }

    // Bah, can't use @Visibility to enforce type-safety on response int.
    public static int getVisibility(final boolean isVisible) {
        return isVisible ? View.VISIBLE : View.GONE;
    }
}
