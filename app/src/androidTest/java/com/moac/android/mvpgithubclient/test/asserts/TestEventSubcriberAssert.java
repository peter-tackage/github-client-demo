package com.moac.android.mvpgithubclient.test.asserts;

import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

/**
 * @author Peter Tackage
 * @since 09/08/15
 */
public class TestEventSubcriberAssert<T> extends AbstractTestSubscriberAssert<T, TestEventSubcriberAssert<T>> {

    protected TestEventSubcriberAssert(TestEventSubscriber<T> actual) {
        super(actual, TestEventSubcriberAssert.class);
    }
}
