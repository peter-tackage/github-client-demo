package com.moac.android.mvpgithubclient.ui.profile.presenter;

import com.moac.android.mvpgithubclient.ui.profile.view.ProfileView;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public interface ProfilePresenter {

    void onViewCreated(ProfileView profileView);

    void onViewDestroyed();
}
