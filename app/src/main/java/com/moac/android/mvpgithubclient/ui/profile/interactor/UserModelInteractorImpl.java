package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.annotation.VisibleForTesting;

import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class UserModelInteractorImpl implements UserModelInteractor {

    private final UserProvider userProvider;
    private final UserViewModelMapper userViewModelMapper;
    private final Scheduler observeOn;

    public UserModelInteractorImpl(UserProvider userProvider) {
        this(userProvider, new UserViewModelMapper(), AndroidSchedulers.mainThread());
    }

    @VisibleForTesting
    UserModelInteractorImpl(UserProvider userProvider,
                            UserViewModelMapper userViewModelMapper,
                            Scheduler observeOn) {
        this.userProvider = userProvider;
        this.userViewModelMapper = userViewModelMapper;
        this.observeOn = observeOn;
    }

    @Override
    public Observable<ProfileViewModel> getProfileViewModel(String username) {
        return userProvider.getUser("peter-tackage")
                .map(userViewModelMapper)
                .observeOn(observeOn);
    }
}
