package com.moac.android.mvpgithubclient;

import android.app.Application;

import com.moac.android.mvpgithubclient.injection.component.ComponentHolder;
import com.moac.android.mvpgithubclient.util.Preconditions;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public abstract class BaseApplication<T> extends Application implements ComponentHolder<T> {

    protected T component;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    @Override
    public final T component() {
        return Preconditions.checkNotNull(component, "Application Component has not been initialized");
    }
}
