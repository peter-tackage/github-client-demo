package com.moac.android.mvpgithubclient.util;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
public class ViewUtilsTest {

    @Test
    public void testActivityRootViewIdIs_Android_R_Id_Content_WhenAnyAndroidVersion() {
        assertThat(ViewUtils.getActivityRootViewId()).isEqualTo(android.R.id.content);
    }

}
