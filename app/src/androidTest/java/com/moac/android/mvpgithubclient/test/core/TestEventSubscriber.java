package com.moac.android.mvpgithubclient.test.core;

import com.moac.android.mvpgithubclient.util.AndroidUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.observers.TestSubscriber;

/**
 * @author Peter Tackage
 * @since 05/08/15
 *
 * Used to test Observers that do not have terminating streams, such as those derived from BehaviorSubjects.
 */
public class TestEventSubscriber<T> extends TestSubscriber<T> {

    private final CountDownLatch eventLatch;

    public TestEventSubscriber(int eventCount) {
        this.eventLatch = new CountDownLatch(eventCount);
    }

    public TestEventSubscriber() {
        this(1);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
        eventLatch.countDown();
    }

    public void awaitEvents() {
        try {
            eventLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
    }

    public void awaitEvents(long timeout, TimeUnit unit) {
        try {
            eventLatch.await(timeout, unit);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
    }

    public void assertObservedOnAndroidMainThread() {
        if(!getLastSeenThread().equals(AndroidUtils.getMainThread())) {
            throw new AssertionError("Not Observed on Android Main Thread.");
        }
    }

}
