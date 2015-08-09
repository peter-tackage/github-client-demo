package com.moac.android.mvpgithubclient.test.asserts;

import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

/**
 * @author Peter Tackage
 * @since 09/08/15
 */
public class Assertions {
    public static <T> AbstractTestSubscriberAssert<T, ?> assertThat(TestEventSubscriber<T> actual) {
        return new TestEventSubcriberAssert<T>(actual);
    }
}
