package com.moac.android.mvpgithubclient.util;

import android.support.annotation.Nullable;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class TextUtils {

    private TextUtils() {
        //no instance
        throw new AssertionError("No instances allowed.");
    }

    public static boolean isNullOrEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }
}
