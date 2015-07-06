package com.moac.android.mvpgithubclient.api.model;

import com.google.auto.value.AutoValue;
import com.moac.android.mvpgithubclient.api.autovalue.AutoGson;

/**
 * @author Peter Tackage
 * @since 04/07/15
 */
@AutoValue
@AutoGson
public abstract class Plan {

    abstract String name();

    abstract Integer space();

    abstract Integer privateRepos();

    abstract Integer collaborators();
}
