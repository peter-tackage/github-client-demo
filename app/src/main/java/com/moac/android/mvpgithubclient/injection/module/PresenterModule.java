package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractor;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module(includes = InteractorModule.class)
public class PresenterModule {

    @Provides
    @PerActivity
    ProfilePresenter provideProfilePresenter(UserModelInteractor userModelInteractor) {
        return new ProfilePresenterImpl(userModelInteractor);
    }

}
