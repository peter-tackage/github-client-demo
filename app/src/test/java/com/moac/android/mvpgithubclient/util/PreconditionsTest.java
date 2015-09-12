package com.moac.android.mvpgithubclient.util;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

@SmallTest
public class PreconditionsTest {

    @Test(expected = IllegalStateException.class)
    public void testCheckNotNullThrows_WhenNull() {
        Preconditions.checkNotNull(null, any(String.class));
    }

    @Test
    public void testResultIsInput_WhenNotNull() {
        Object value = new Object();
        assertThat(Preconditions.checkNotNull(value, any(String.class))).isEqualTo(value);
    }

    // TODO More boiler plate tests

}
