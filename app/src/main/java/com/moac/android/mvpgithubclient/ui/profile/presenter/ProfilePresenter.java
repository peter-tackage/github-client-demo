package com.moac.android.mvpgithubclient.ui.profile.presenter;

import com.moac.android.mvpgithubclient.ui.profile.view.ProfileView;

/**
 * @author Peter Tackage
 * @since 07/07/15
 *
 * Presenters should be kept as Android dependency free as possible
 */
public interface ProfilePresenter {

    void onViewCreated(ProfileView profileView);

    void onViewDestroyed();
}
