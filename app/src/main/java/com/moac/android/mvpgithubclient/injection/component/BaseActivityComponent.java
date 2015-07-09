package com.moac.android.mvpgithubclient.injection.component;

import android.app.Activity;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.injection.module.ForActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = BaseApplicationComponent.class, modules = BaseActivityModule.class)
public interface BaseActivityComponent {
    Activity getActivity();

    @ForActivity
    Context getActivityContext();
}
