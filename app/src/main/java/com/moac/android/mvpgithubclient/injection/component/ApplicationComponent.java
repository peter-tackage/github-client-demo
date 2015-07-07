package com.moac.android.mvpgithubclient.injection.component;

import android.app.Application;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.module.ApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.DataModule;
import com.moac.android.mvpgithubclient.injection.module.ForApplication;
import com.moac.android.mvpgithubclient.injection.module.GithubApiModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;
import com.moac.android.mvpgithubclient.injection.module.InstrumentationModule;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class, GithubApiModule.class, ImagesModule.class,
        DataModule.class, InstrumentationModule.class})
@Singleton
public interface ApplicationComponent {
    Application getApplication();

    @ForApplication
    Context getApplicationContext();

    UserProvider getUserProvider();

    Picasso getPicasso();

    void inject(Application application);
}
