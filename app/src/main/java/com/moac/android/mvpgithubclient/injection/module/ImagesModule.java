package com.moac.android.mvpgithubclient.injection.module;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseApplicationModule.class)
public class ImagesModule {

    @Provides
    @Singleton
    Picasso providePicasso(@ForApplication Context context) {
        return Picasso.with(context);
    }

}
