package com.moac.android.mvpgithubclient.util;

import rx.Subscription;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public final class RxUtils {

    private RxUtils() {
        //no instance
        throw new AssertionError("No instances allowed.");
    }

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
