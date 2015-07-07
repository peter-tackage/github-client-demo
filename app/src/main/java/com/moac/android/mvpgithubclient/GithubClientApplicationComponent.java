package com.moac.android.mvpgithubclient;

import com.moac.android.mvpgithubclient.injection.component.BaseApplicationComponent;
import com.moac.android.mvpgithubclient.injection.module.DataModule;
import com.moac.android.mvpgithubclient.injection.module.ImagesModule;
import com.moac.android.mvpgithubclient.injection.module.InstrumentationModule;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { ImagesModule.class, DataModule.class, InstrumentationModule.class})
@Singleton
public interface GithubClientApplicationComponent extends BaseApplicationComponent {

    UserProvider getUserProvider();

    Picasso getPicasso();
}
