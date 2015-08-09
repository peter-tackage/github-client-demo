package com.moac.android.mvpgithubclient.test.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.observers.TestSubscriber;

/**
 * @author Peter Tackage
 * @since 05/08/15
 * <p/>
 * Used to test Observers that do not have terminating streams, such as those derived from BehaviorSubjects.
 */
public class TestEventSubscriber<T> extends TestSubscriber<T> {

    private final CountDownLatch onNextEventLatch;

    public TestEventSubscriber(int eventCount) {
        super();
        this.onNextEventLatch = new CountDownLatch(eventCount);
    }

    public TestEventSubscriber() {
        this(1);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
        onNextEventLatch.countDown();
    }

    public void awaitOnNextEvents() {
        try {
            onNextEventLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
    }

    public void awaitOnNextEvents(long timeout, TimeUnit unit) {
        try {
            onNextEventLatch.await(timeout, unit);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
    }

}
