package com.moac.android.mvpgithubclient.injection.module;

import android.app.Activity;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    private final Activity activity;

    public BaseActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

}
