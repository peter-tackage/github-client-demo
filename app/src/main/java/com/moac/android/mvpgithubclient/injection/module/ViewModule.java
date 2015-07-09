package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.SnackbarErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileView;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewImpl;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    @Provides
    @PerActivity
    ProfileView provideProfileView(Picasso picasso, ErrorRenderer errorRenderer) {
        return new ProfileViewImpl(picasso, errorRenderer);
    }

    @Provides
    @PerActivity
    ErrorRenderer provideErrorRenderer() {
        return new SnackbarErrorRenderer();
    }

}
