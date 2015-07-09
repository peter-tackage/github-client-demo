package com.moac.android.mvpgithubclient;

import com.moac.android.mvpgithubclient.injection.component.BaseApplicationComponent;
import com.moac.android.mvpgithubclient.injection.module.BaseApplicationModule;
import com.moac.android.mvpgithubclient.injection.module.DataModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BaseApplicationModule.class, ImagesModule.class, DataModule.class})
public interface GithubClientApplicationComponent extends BaseApplicationComponent {

    UserProvider getUserProvider();

    Picasso getPicasso();
}
