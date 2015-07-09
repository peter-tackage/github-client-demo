package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenterImpl;

import dagger.Module;
import dagger.Provides;

@PerActivity
@Module(includes = DataModule.class)
public class PresenterModule {

    @Provides
    ProfilePresenter profileProfilePresenter(UserProvider userProvider) {
        return new ProfilePresenterImpl(userProvider);
    }

}
