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

        // Create & run new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AndroidPreconditions.checkOnMainThread();
                } catch (IllegalStateException ise) {
                    // Catch expected Exception
                    countDownLatch.countDown();
                }
            }
        }).start();

        // Give it 5 seconds to countdown or throw
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

    public void testDoesNotThrow_WhenMainThread() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        // Post to main looper
        new Handler(Looper.getMainLooper()).post(new Runnable() {
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
