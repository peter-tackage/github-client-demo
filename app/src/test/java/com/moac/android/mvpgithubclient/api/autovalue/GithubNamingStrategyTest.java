package com.moac.android.mvpgithubclient.api.autovalue;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
@RunWith(PowerMockRunner.class)
@SmallTest
public class GithubNamingStrategyTest {

    private static final String FIELD_NAME_UNDER_TEST = "fieldName1";

    private static class DummyClass {
        private int fieldName1;
        private int fieldName2;
    }

    @PrepareForTest(FieldNamingStrategyUtils.class)
    @Test
    public void testUtilArgumentIsFieldName_WhenInvoked() throws NoSuchFieldException {
        PowerMockito.mockStatic(FieldNamingStrategyUtils.class);

        GithubFieldNamingStrategy namingStrategy = new GithubFieldNamingStrategy();
        namingStrategy.translateName(getTestField(FIELD_NAME_UNDER_TEST));

        PowerMockito.verifyStatic();
        FieldNamingStrategyUtils.convertToDelimited(FIELD_NAME_UNDER_TEST);
    }

    @Test
    public void testResultIsEqualToConvertToDelimited() throws NoSuchFieldException {
        assertThat(new GithubFieldNamingStrategy()
                .translateName(getTestField(FIELD_NAME_UNDER_TEST)))
                .isEqualTo(FieldNamingStrategyUtils.convertToDelimited(FIELD_NAME_UNDER_TEST));

    }

    private static Field getTestField(String fieldName) throws NoSuchFieldException {
        return DummyClass.class.getDeclaredField(fieldName);
    }

}
