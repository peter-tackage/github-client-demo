package com.moac.android.mvpgithubclient.util;

import android.os.Looper;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class AndroidUtils {

    private AndroidUtils() {
        //no instance
        throw new AssertionError("No instances allowed.");
    }

    public static Looper getAndroidMainLooper() {
        return Looper.getMainLooper();
    }

    public static Thread getAndroidMainThread() {
        return getAndroidMainLooper().getThread();
    }
}
