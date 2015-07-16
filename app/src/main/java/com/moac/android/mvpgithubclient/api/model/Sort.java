package com.moac.android.mvpgithubclient.api.model;

import android.support.annotation.NonNull;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public enum Sort {
    FOLLOWERS("followers"), REPOSITORIES("repositories"), JOINED("joined");

    @NonNull
    private final String queryParam;

    Sort(@NonNull String queryParam) {
        this.queryParam = queryParam;
    }

    @Override
    @NonNull
    public String toString() {
        return queryParam;
    }
}
