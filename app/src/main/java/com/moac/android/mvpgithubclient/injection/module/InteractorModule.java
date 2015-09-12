package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.provider.SearchProvider;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserByNameInteractor;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserProfile;
import com.moac.android.mvpgithubclient.ui.search.interactor.GetUsersBySearch;
import com.moac.android.mvpgithubclient.ui.search.interactor.GetUsersBySearchInteractor;
import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractor;
import com.moac.android.mvpgithubclient.ui.search.interactor.SearchQueryInteractorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @PerActivity
    GetUserProfile provideGetUserByName(UserProvider userProvider,
                                        SchedulerProvider schedulerProvider) {
        return new GetUserByNameInteractor(userProvider, schedulerProvider);
    }

    @Provides
    @PerActivity
    GetUsersBySearch provideGetUsersBySearch(SearchProvider searchProvider) {
        return new GetUsersBySearchInteractor(searchProvider);
    }

    @Provides
    @PerActivity
    SearchQueryInteractor provideSearchQueryInteractor(SchedulerProvider schedulerProvider) {
        return new SearchQueryInteractorImpl(schedulerProvider);
    }

}
