package com.moac.android.mvpgithubclient.api.autovalue;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.util.Preconditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Tackage
 * @since 05/07/15
 */
public final class FieldNamingStrategyUtils {

    private static final Pattern CAPITAL_CHARACTER_PATTERN = Pattern.compile("[A-Z]");
    private static final String UNDERSCORE = "_";

    private FieldNamingStrategyUtils() {
        //no instance
    }

    @NonNull
    public static String convertToDelimited(@NonNull String fieldName) {
        Preconditions.checkNotNullOrEmpty(fieldName, "Field name cannot be null or empty");

        Matcher matcher = CAPITAL_CHARACTER_PATTERN.matcher(fieldName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find() && matcher.start() != 0) {
            matcher.appendReplacement(sb, toDelimited(matcher.group()));
        }
        return matcher.appendTail(sb).toString();
    }

    @NonNull
    private static String toDelimited(String s) {
        return UNDERSCORE + s.toLowerCase();
    }
}
