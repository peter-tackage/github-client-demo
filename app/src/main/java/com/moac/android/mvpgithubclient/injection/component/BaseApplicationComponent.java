package com.moac.android.mvpgithubclient.injection.component;

import android.app.Application;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.module.BaseApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.ForApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = BaseApplicationModule.class)
public interface BaseApplicationComponent {
    Application getApplication();

    @ForApplication
    Context getApplicationContext();

    void inject(Application application);
}
