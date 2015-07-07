package com.moac.android.mvpgithubclient.injection.component;

import android.app.Activity;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.module.ActivityModule;
import com.moac.android.mvpgithubclient.injection.module.ForActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = BaseApplicationComponent.class, modules = ActivityModule.class)
public interface BaseActivityComponent {
    Activity getActivity();

    @ForActivity
    Context getActivityContext();
}
