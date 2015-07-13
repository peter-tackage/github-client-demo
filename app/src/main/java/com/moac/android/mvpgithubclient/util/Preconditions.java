package com.moac.android.mvpgithubclient.util;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class Preconditions {

    private Preconditions() {
        //no instance
        throw new AssertionError("No instances allowed");
    }

    public static <T> T checkNotNull(@Nullable T value, @NonNull String errorMessage) {
        if (value == null) {
            throw new IllegalStateException(errorMessage);
        }
        return value;
    }

    public static String checkNotNullOrEmpty(@Nullable String value, @NonNull String errorMessage) {
        if (TextUtils.isNullOrEmpty(value)) {
            throw new IllegalStateException(errorMessage);
        }
        return value;
    }

    public static void checkOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("This method must be called from the Android main thread, not: " + Thread.currentThread());
        }
    }
}
