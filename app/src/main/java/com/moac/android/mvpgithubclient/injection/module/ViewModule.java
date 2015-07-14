package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.core.view.SnackbarErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContractImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    @Provides
    @PerActivity
    ProfileViewContract provideProfileView(PicassoImageLoader picassoImageLoader, ErrorRenderer errorRenderer) {
        return new ProfileViewContractImpl(picassoImageLoader, errorRenderer);
    }

    @Provides
    @PerActivity
    ErrorRenderer provideErrorRenderer() {
        return new SnackbarErrorRenderer();
    }

}
