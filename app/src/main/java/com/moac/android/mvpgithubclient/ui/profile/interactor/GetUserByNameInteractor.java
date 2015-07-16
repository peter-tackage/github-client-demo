package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class GetUserByNameInteractor implements GetUserProfile {

    @NonNull private final UserProvider userProvider;
    @NonNull private final UserViewModelMapper userViewModelMapper;
    @NonNull private final Scheduler observeOn;

    public GetUserByNameInteractor(@NonNull UserProvider userProvider) {
        this(userProvider, new UserViewModelMapper(), AndroidSchedulers.mainThread());
    }

    @VisibleForTesting
    GetUserByNameInteractor(@NonNull UserProvider userProvider,
                            @NonNull UserViewModelMapper userViewModelMapper,
                            @NonNull Scheduler observeOn) {

        checkNotNull(userProvider, "Parameter userModelInteractor cannot be null.");
        checkNotNull(userViewModelMapper, "Parameter userViewModelMapper cannot be null.");
        checkNotNull(observeOn, "Parameter observeOn cannot be null.");

        this.userProvider = userProvider;
        this.userViewModelMapper = userViewModelMapper;
        this.observeOn = observeOn;
    }

    @Override
    @NonNull
    public Observable<ProfileViewModel> call(@NonNull String username) {
        return userProvider.getUser(username)
                .map(userViewModelMapper)
                .observeOn(observeOn);
    }
}
