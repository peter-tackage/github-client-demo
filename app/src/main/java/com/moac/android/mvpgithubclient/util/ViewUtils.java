package com.moac.android.mvpgithubclient.util;

import android.support.annotation.IdRes;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public final class ViewUtils {
    private ViewUtils() {
        //no instance
        throw new AssertionError("No instances allowed");
    }

    @IdRes
    public static int getActivityRootViewId() {
        return android.R.id.content;
    }
}
