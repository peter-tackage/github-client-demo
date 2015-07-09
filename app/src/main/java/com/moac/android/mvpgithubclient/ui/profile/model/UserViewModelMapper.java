package com.moac.android.mvpgithubclient.ui.profile.model;

import com.moac.android.mvpgithubclient.api.model.User;

import rx.functions.Func1;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class UserViewModelMapper implements Func1<User, ProfileViewModel> {
    @Override
    public ProfileViewModel call(User user) {
        return ProfileViewModel.from(user.avatarUrl(), user.login(), user.name(), user.location());
    }
}