package com.moac.android.mvpgithubclient.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class Preconditions {

    private Preconditions() {
        //no instance
    }

    public static String checkNotNullOrEmpty(@Nullable String value, @NonNull String errorMessage) {
        if (TextUtils.isNullOrEmpty(value)) {
            throw new IllegalStateException(errorMessage);
        }
        return value;
    }
}
