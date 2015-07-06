package com.moac.android.mvpgithubclient.api.autovalue;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * @author Peter Tackage
 * @since 04/07/15
 */
public class GithubFieldNamingStrategy implements FieldNamingStrategy {

    // TODO This should cache if Gson doesn't.

    @Override
    public String translateName(Field f) {
        return FieldNamingStrategyUtils.convertToDelimited(f.getName());
    }

}
