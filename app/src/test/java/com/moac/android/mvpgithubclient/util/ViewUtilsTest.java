package com.moac.android.mvpgithubclient.util;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
public class ViewUtilsTest {

    @Test
    public void testActivityRootViewIdIs_Android_R_Id_Content_WhenAnyAndroidVersion() {
        assertThat(ViewUtils.getActivityRootViewId()).isEqualTo(android.R.id.content);
    }

}
