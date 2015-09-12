package com.moac.android.mvpgithubclient.test.asserts;

import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;
import com.moac.android.mvpgithubclient.util.AndroidUtils;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.Failures;
import org.assertj.core.internal.Numbers;
import org.assertj.core.internal.Objects;
import org.assertj.core.util.VisibleForTesting;

import static org.assertj.core.error.ShouldBeSame.shouldBeSame;

/**
 * @author Peter Tackage
 * @since 09/08/15
 */
class Subscribers {

    private static final Subscribers INSTANCE = new Subscribers();

    @VisibleForTesting
    Failures failures = Failures.instance();

    public static Subscribers instance() {
        return INSTANCE;
    }

    public <T> void assertObservedOnMainThread(AssertionInfo info, TestEventSubscriber<T> actual) {
        assertNotNull(info, actual);

        if (actual.getLastSeenThread() == AndroidUtils.getAndroidMainThread()) {
            return;
        }
        throw failures.failure(info, shouldBeSame(actual.getLastSeenThread(), AndroidUtils.getAndroidMainThread()));
    }

    public <T> void assertEventCount(AssertionInfo info, TestEventSubscriber<T> actual, int expected) {
        assertNotNull(info, actual);
        assertNotNull(info, actual.getOnNextEvents());
        assertNotNegative(info, expected);

        if (actual.getOnNextEvents().size() == expected) {
            return;
        }
        throw failures.failure(info, shouldBeSame(actual.getOnNextEvents().size(), expected));

    }

    private static void assertNotNull(AssertionInfo info, Object subscriber) {
        Objects.instance().assertNotNull(info, subscriber);
    }

    private static void assertNotNegative(AssertionInfo info, int actual) {
        Numbers.instance().assertGreaterThanOrEqualTo(info, actual, 0);
    }

}
