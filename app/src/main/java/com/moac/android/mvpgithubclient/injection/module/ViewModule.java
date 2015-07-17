package com.moac.android.mvpgithubclient.injection.module;

import android.app.Activity;
import android.content.Context;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.core.view.SnackbarErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContractImpl;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContractImpl;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContractImpl;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseActivityModule.class)
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
    SearchResultViewContract provideSearchResultView(@ForActivity Context context,
                                                     PicassoImageLoader picassoImageLoader,
                                                     ErrorRenderer errorRenderer) {
        return new SearchResultViewContractImpl(context, picassoImageLoader, errorRenderer);
    }

    // Search Query

    @Provides
    @PerActivity
    SearchQueryViewContract provideSearchQueryView(Activity activity) {
        return new SearchQueryViewContractImpl(activity);
    }
}
