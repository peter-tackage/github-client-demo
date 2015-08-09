package com.moac.android.mvpgithubclient.test.asserts;

import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.VisibleForTesting;

/**
 * @author Peter Tackage
 * @since 09/08/15
 */
public abstract class AbstractTestSubscriberAssert<T, S extends AbstractTestSubscriberAssert<T, S>> extends AbstractObjectAssert<S, TestEventSubscriber<T>> {

    @VisibleForTesting
    Subscribers subscribers = Subscribers.instance();

    protected AbstractTestSubscriberAssert(TestEventSubscriber<T> actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public S wasObservedOnAndroidMainThread() {
        subscribers.assertObservedOnMainThread(info, actual);
        return myself;
    }

}
