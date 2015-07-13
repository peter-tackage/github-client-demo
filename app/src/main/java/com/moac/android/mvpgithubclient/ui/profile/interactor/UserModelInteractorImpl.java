package com.moac.android.mvpgithubclient.ui.profile.interactor;

import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class UserModelInteractorImpl implements UserModelInteractor {

    private final UserProvider userProvider;

    public UserModelInteractorImpl(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public Observable<ProfileViewModel> getProfileViewModel(String username) {
        return userProvider.getUser("peter-tackage")
                .map(new UserViewModelMapper())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
