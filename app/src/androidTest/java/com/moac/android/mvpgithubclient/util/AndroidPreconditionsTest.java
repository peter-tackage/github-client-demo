package com.moac.android.mvpgithubclient.util;

import android.os.Handler;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 13/07/15
 * <p/>
 * This doesn't need to subclass {@link com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase}
 * as it doesn't use Dexmaker or require a Context.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class AndroidPreconditionsTest {

    @Test
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

        assertThat(countDownLatch.getCount()).isZero();
    }

    @Test
    public void testDoesNotThrow_WhenMainThread() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        // Post to main looper
        new Handler(AndroidUtils.getAndroidMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                AndroidPreconditions.checkOnMainThread();
                // Count down if no Exception thrown
                countDownLatch.countDown();
            }
        });

        // Give it 5 seconds to countdown or throw
        countDownLatch.await(5, TimeUnit.SECONDS);

        assertThat(countDownLatch.getCount()).isZero();

        /**
         * This could have also been performed using -
         *
         *  InstrumentationRegistry.getInstrumentation().runOnMainSync(
         *      new Runnable() { public void run() { AndroidPreconditions.checkOnMainThread(); } });
         *
         */
    }

}
