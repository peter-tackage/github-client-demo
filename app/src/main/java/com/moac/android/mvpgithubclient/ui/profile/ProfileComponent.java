package com.moac.android.mvpgithubclient.ui.profile;

import com.moac.android.mvpgithubclient.injection.component.BaseApplicationComponent;
import com.moac.android.mvpgithubclient.injection.component.BaseActivityComponent;
import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.injection.module.ActivityModule;

import dagger.Component;

/**
 * @author Peter Tackage
 * @since 16/04/15
 */

@PerActivity
@Component(dependencies = BaseApplicationComponent.class, modules = ActivityModule.class)
public interface ProfileComponent extends BaseActivityComponent {
    void inject(ProfileActivity profileActivity);

   // void inject(SoundMapFragment mapFragment);
}
