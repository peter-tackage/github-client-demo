package com.moac.android.mvpgithubclient;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.moac.android.mvpgithubclient.injection.module.ApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.ConfigModule;
import com.moac.android.mvpgithubclient.injection.module.GithubApiModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;

public class GithubClientApplication extends BaseApplication<GithubClientApplicationComponent> {

    private static final String TAG = GithubClientApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        component().inject(this);
        initStetho(this);
    }

    @Override
    public void initComponent() {
        component = DaggerGithubClientApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .githubApiModule(new GithubApiModule())
                .imagesModule(new ImagesModule())
                .configModule(new ConfigModule())
                .build();
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
