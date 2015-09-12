package com.moac.android.mvpgithubclient.util;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
public class TextUtilsTest {

    @Test
    public void testIsNullOrEmpty_WhenNull() {
        assertThat(TextUtils.isNullOrEmpty(null)).isTrue();
    }

    @Test
    public void testIsNullOrEmpty_WhenEmpty() {
        assertThat(TextUtils.isNullOrEmpty("")).isTrue();
    }

    @Test
    public void testNotIsNullOrEmpty_WhenNotEmpty() {
        assertThat(TextUtils.isNullOrEmpty("value")).isFalse();
    }
}
