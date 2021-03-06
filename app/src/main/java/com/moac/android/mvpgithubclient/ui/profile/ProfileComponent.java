package com.moac.android.mvpgithubclient.ui.profile;

import com.moac.android.mvpgithubclient.GithubClientApplicationComponent;
import com.moac.android.mvpgithubclient.injection.component.BaseActivityComponent;
import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.injection.module.PresenterModule;
import com.moac.android.mvpgithubclient.injection.module.ViewModule;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserProfile;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;

import dagger.Component;

@PerActivity
@Component(dependencies = GithubClientApplicationComponent.class,
        modules = {BaseActivityModule.class, PresenterModule.class, ViewModule.class})
public interface ProfileComponent extends BaseActivityComponent {

    ProfilePresenter provideProfilePresenter();

    ProfileViewContract provideProfileView();

    GetUserProfile provideUserModelInteractor();

    void inject(ProfileActivity profileActivity);

}
