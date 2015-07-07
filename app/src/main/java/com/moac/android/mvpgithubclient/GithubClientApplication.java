package com.moac.android.mvpgithubclient;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.moac.android.mvpgithubclient.injection.component.ApplicationComponent;
import com.moac.android.mvpgithubclient.injection.component.DaggerApplicationComponent;
import com.moac.android.mvpgithubclient.injection.module.ApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.ConfigModule;
import com.moac.android.mvpgithubclient.injection.module.GithubApiModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;

public class GithubClientApplication extends Application {

    private static final String TAG = GithubClientApplication.class.getSimpleName();

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho(this);
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .githubApiModule(new GithubApiModule())
                .imagesModule(new ImagesModule())
                .configModule(new ConfigModule())
                .build();
        component().inject(this);
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }

    private static void initStetho(Context context) {
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(context))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(context))
                        .build());
    }
}
