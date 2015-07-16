package com.moac.android.mvpgithubclient.injection.module;

import android.content.Context;

import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ImagesModule {

    @Provides
    @Singleton
    PicassoImageLoader picassoImageLoader(Picasso picasso) {
        return new PicassoImageLoader(picasso);
    }

    // Internal

    @Provides
    @Singleton
    Picasso providePicasso(@ForApplication Context context) {
        return Picasso.with(context);
    }

}
