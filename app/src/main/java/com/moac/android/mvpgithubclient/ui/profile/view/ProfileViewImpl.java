package com.moac.android.mvpgithubclient.ui.profile.view;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import butterknife.ButterKnife;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class ProfileViewImpl implements ProfileView {

    private final View rootView;

    public ProfileViewImpl(View rootView) {
        this.rootView = rootView;
        ButterKnife.bind(this, rootView);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent(ProfileViewModel profileViewModel) {

    }

    @Override
    public void showError(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show();
    }
}
