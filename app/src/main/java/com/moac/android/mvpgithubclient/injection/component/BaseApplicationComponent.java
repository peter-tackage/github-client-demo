package com.moac.android.mvpgithubclient.injection.component;

import android.app.Application;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.module.ApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.DataModule;
import com.moac.android.mvpgithubclient.injection.module.ForApplication;
import com.moac.android.mvpgithubclient.injection.module.GithubApiModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;
import com.moac.android.mvpgithubclient.injection.module.InstrumentationModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = ApplicationModule.class)
@Singleton
public interface BaseApplicationComponent {
    Application getApplication();

    @ForApplication
    Context getApplicationContext();

    void inject(Application application);
}
