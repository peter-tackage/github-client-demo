package com.moac.android.mvpgithubclient.api.model;

import com.google.auto.value.AutoValue;
import com.moac.android.mvpgithubclient.api.autovalue.AutoGson;

import java.util.List;

/**
 * @author Peter Tackage
 * @since 17/07/15
 */
@AutoValue
@AutoGson(autoValueClass = AutoValue_UserSearchResult.class)
public abstract class UserSearchResult extends SearchResult<User> {
    public abstract List<User> items(); // AutoValue requires the generic parameter value
}
