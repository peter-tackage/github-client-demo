package com.moac.android.mvpgithubclient.test.asserts;

import com.moac.android.mvpgithubclient.test.core.TestEventSubscriber;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.VisibleForTesting;

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

    public S hasOnNextEventCount(int expectedSize) {
        Iterables.instance().assertHasSize(info, actual.getOnNextEvents(), expectedSize);
        return myself;
    }

    // TODO Make these use the TestSubscriber assertions somehow - don't repeat their logic.
    // TODO Use the await() ??

    public S hasTerminated() {
        actual.assertTerminalEvent();
        return myself;
    }

    public S hasNoErrors() {
        actual.assertNoErrors();
        return myself;
    }

    public S hasCompleted() {
        actual.assertNoErrors();
        actual.assertTerminalEvent();
        return myself;
    }

    public S hasOnErrored() {
        Iterables.instance().assertHasSize(info, actual.getOnErrorEvents(), 1);
        Iterables.instance().assertHasSize(info, actual.getOnCompletedEvents(), 0);
        return myself;
    }

}
