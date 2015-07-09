package com.moac.android.mvpgithubclient.ui.profile;

import com.moac.android.mvpgithubclient.injection.component.BaseActivityComponent;
import com.moac.android.mvpgithubclient.injection.component.BaseApplicationComponent;
import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.injection.module.PresenterModule;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;

import dagger.Component;

/**
 * @author Peter Tackage
 * @since 16/04/15
 */

//@PerActivity
//@Component(dependencies = BaseApplicationComponent.class, modules = {BaseActivityModule.class, PresenterModule.class})
public interface ProfileComponent extends BaseActivityComponent {

    ProfilePresenter provideProfilePresenter();

    void inject(ProfileActivity profileActivity);

    // void inject(SoundMapFragment mapFragment);
}
