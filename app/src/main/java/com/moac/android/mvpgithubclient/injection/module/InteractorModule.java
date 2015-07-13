package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractor;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @PerActivity
    UserModelInteractor provideUserModelInteractor(UserProvider userProvider) {
        return new UserModelInteractorImpl(userProvider);
    }

}
