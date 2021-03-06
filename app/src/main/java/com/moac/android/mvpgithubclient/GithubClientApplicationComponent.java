package com.moac.android.mvpgithubclient;

import com.moac.android.mvpgithubclient.injection.component.BaseApplicationComponent;
import com.moac.android.mvpgithubclient.injection.module.BaseApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.DataModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;
import com.moac.android.mvpgithubclient.injection.module.SchedulerModule;
import com.moac.android.mvpgithubclient.provider.SearchProvider;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BaseApplicationModule.class, SchedulerModule.class, ImagesModule.class, DataModule.class})
public interface GithubClientApplicationComponent extends BaseApplicationComponent {

    UserProvider getUserProvider();

    SearchProvider getSearchProvider();

    PicassoImageLoader getPicassoImageLoader();

    SchedulerProvider schedulerProvider();
}
