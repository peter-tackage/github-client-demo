package com.moac.android.mvpgithubclient.util;

import static com.moac.android.mvpgithubclient.util.AndroidUtils.getAndroidMainThread;

public final class AndroidPreconditions {

    private AndroidPreconditions() {
        throw new AssertionError("No instances allowed.");
    }

    public static void checkOnMainThread() {
        if (Thread.currentThread() != getAndroidMainThread()) {
            throw new IllegalStateException("This method must be called from the Android main thread, not: " + Thread.currentThread());
        }
    }

}
