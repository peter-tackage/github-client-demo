package com.moac.android.mvpgithubclient.api.util;

import android.support.annotation.Nullable;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class TextUtils {

    private TextUtils() {
        //no instance
    }

    public static boolean isNullOrEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }
}
