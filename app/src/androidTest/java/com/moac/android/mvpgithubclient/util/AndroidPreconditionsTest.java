package com.moac.android.mvpgithubclient.util;

import android.os.Handler;
import android.os.Looper;

import com.moac.android.mvpgithubclient.test.core.PatchedAndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class AndroidPreconditionsTest extends PatchedAndroidTestCase {

    public void testThrows_WhenNonMainThread() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread nonMainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AndroidPreconditions.checkOnMainThread();
                } catch (IllegalStateException ise) {
                    // Catch expected Exception
                    countDownLatch.countDown();
                }
            }
        });
        // Create & run new thread
        nonMainThread.start();

        // Give it 5 seconds to countdown or throw
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

    public void testDoesNotThrow_WhenMainThread() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                AndroidPreconditions.checkOnMainThread();
                // Count down if no Exception thrown
                countDownLatch.countDown();
            }
        });
        // Give it 5 seconds to countdown or throw
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

}
