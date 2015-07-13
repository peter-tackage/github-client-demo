package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractor;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractorImpl;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;

@Module
public class InteractorModule {

    @Provides
    @PerActivity
    UserModelInteractor provideUserModelInteractor(UserProvider userProvider, UserViewModelMapper userViewModelMapper) {
        return new UserModelInteractorImpl(userProvider, userViewModelMapper);
    }

}
