package com.moac.android.mvpgithubclient.util;

import android.os.Looper;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class AndroidPreconditions {

    private AndroidPreconditions() {
        //no instance
        throw new AssertionError("No instances allowed");
    }

    public static void checkOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("This method must be called from the Android main thread, not: " + Thread.currentThread());
        }
    }
}
