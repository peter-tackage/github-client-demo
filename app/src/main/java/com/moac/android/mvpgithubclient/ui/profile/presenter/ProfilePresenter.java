package com.moac.android.mvpgithubclient.ui.profile.presenter;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;

/**
 * @author Peter Tackage
 * @since 07/07/15
 *
 * Presenters should be kept as Android dependency free as possible
 */
public interface ProfilePresenter {

    void bindView(@NonNull ProfileViewContract profileView);

    void unbindView();
}
