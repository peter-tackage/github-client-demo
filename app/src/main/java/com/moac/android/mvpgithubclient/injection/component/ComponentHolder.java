package com.moac.android.mvpgithubclient.injection.component;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public interface ComponentHolder<T> {
    T component();

    void initComponent();
}
