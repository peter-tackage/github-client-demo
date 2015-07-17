package com.moac.android.mvpgithubclient.api.model;

import java.util.List;

/**
 * @author Peter Tackage
 * @since 17/07/15
 *
 * AutoValue doesn't play well with generics as it needs to know the type at compile time.
 * This abstract class should be subclassed by those actual models that provide the concrete
 * type information.
 */
abstract class SearchResult<T> {
    public abstract int totalCount();

    public abstract boolean incompleteResults();

    public abstract List<T> items();
}
