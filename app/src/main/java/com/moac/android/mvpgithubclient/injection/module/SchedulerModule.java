package com.moac.android.mvpgithubclient.injection.module;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.scheduler.AndroidSchedulerProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SchedulerModule {

    @Provides
    @NonNull
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return new AndroidSchedulerProvider();
    }

}
