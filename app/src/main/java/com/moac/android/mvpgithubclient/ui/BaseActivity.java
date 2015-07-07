package com.moac.android.mvpgithubclient.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.moac.android.mvpgithubclient.injection.component.ComponentHolder;
import com.moac.android.mvpgithubclient.util.Preconditions;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public abstract class BaseActivity<T> extends AppCompatActivity implements ComponentHolder<T> {

    protected T component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
    }

    @Override
    public final T component() {
        return Preconditions.checkNotNull(component, "Activity Component has not been initialized");
    }
}
