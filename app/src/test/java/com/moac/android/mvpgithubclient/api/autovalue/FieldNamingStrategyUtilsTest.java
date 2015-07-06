package com.moac.android.mvpgithubclient.api.autovalue;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
@SmallTest
public class FieldNamingStrategyUtilsTest {

    @Test
    public void testIsNotDelimited_WhenSingleCharacterWithoutUpperCase() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("a")).isEqualTo("a");
    }

    @Test
    public void testIsNotDelimited_WhenSingleCharacterWithUpperCase() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("A")).isEqualTo("A");
    }

    @Test
    public void testIsNotDelimited_WhenSingleWordWithoutUpperCase() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("abcd")).isEqualTo("abcd");
    }

    @Test
    public void testIsNotDelimited_WhenSingleWordWithUpperCaseAndTrailingContent() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("Aa")).isEqualTo("Aa");
    }

    @Test
    public void testIsDelimited_WhenTwoWords() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("aB")).isEqualTo("a_b");
    }

    @Test
    public void testIsDelimited_WhenMultipleSingleCharacterWords() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("aBCD")).isEqualTo("a_b_c_d");
    }

    @Test
    public void testIsDelimited_WhenTwoWordsWithTrailingCharacters() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("aBb")).isEqualTo("a_bb");
    }

    @Test
    public void testIsDelimited_WhenMultipleWordsWithTrailingCharacters() {
        assertThat(FieldNamingStrategyUtils.convertToDelimited("aaBbCcDd")).isEqualTo("aa_bb_cc_dd");
    }

}
