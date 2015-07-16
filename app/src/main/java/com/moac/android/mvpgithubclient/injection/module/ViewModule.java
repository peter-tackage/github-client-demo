package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.core.view.SnackbarErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContractImpl;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContractImpl;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    // Error Renderer

    @Provides
    @PerActivity
    ErrorRenderer provideErrorRenderer() {
        return new SnackbarErrorRenderer();
    }

    // Profile

    @Provides
    @PerActivity
    ProfileViewContract provideProfileView(PicassoImageLoader picassoImageLoader, ErrorRenderer errorRenderer) {
        return new ProfileViewContractImpl(picassoImageLoader, errorRenderer);
    }

    // Search Results

    @Provides
    @PerActivity
    SearchResultViewContract provideSearchResultView(PicassoImageLoader picassoImageLoader, ErrorRenderer errorRenderer) {
        return new SearchResultViewContractImpl(picassoImageLoader, errorRenderer);
    }

}
