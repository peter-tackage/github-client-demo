package com.moac.android.mvpgithubclient.api.model;

import android.support.annotation.NonNull;

/**
 * @author Peter Tackage
 * @since 15/07/15
 */
public enum Order {
    ASCENDING("asc"), DESCENDING("desc");

    @NonNull
    private final String queryParam;

    Order(@NonNull String queryParam) {
        this.queryParam = queryParam;
    }

    @Override
    @NonNull
    public String toString() {
        return queryParam;
    }
}
