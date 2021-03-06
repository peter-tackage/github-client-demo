package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserProfile;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenterImpl;
import com.moac.android.mvpgithubclient.ui.search.interactor.GetUsersBySearchInteractor;
import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractor;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchQueryPresenter;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchQueryPresenterImpl;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchResultPresenter;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchResultPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module(includes = InteractorModule.class)
public class PresenterModule {

    // Search Results

    @Provides
    @PerActivity
    SearchResultPresenter provideSearchResultPresenter(GetUsersBySearchInteractor getUsersBySearch,
                                                       SearchQueryInteractor searchQueryInteractor) {
        return new SearchResultPresenterImpl(getUsersBySearch, searchQueryInteractor);
    }

    // Search Query

    @Provides
    @PerActivity
    SearchQueryPresenter provideSearchQueryPresenter(SearchQueryInteractor searchQueryInteractor) {
        return new SearchQueryPresenterImpl(searchQueryInteractor);
    }


    // Profile

    @Provides
    @PerActivity
    ProfilePresenter provideProfilePresenter(GetUserProfile getUserProfile) {
        return new ProfilePresenterImpl(getUserProfile);
    }

}
