package com.moac.android.mvpgithubclient.ui.profile.interactor;

import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public interface UserModelInteractor {

    Observable<ProfileViewModel> getProfileViewModel(String username);
}
