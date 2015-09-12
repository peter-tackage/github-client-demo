package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import rx.Observable;
import rx.functions.Func1;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

public class GetUserByNameInteractor implements GetUserProfile {

    @NonNull private final UserProvider userProvider;
    @NonNull private final SchedulerProvider schedulerProvider;

    public GetUserByNameInteractor(@NonNull UserProvider userProvider,
                                   @NonNull SchedulerProvider schedulerProvider) {

        checkNotNull(userProvider, "Parameter userModelInteractor cannot be null.");
        checkNotNull(schedulerProvider, "Parameter schedulerProvider cannot be null.");

        this.userProvider = userProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    @NonNull
    public Observable<ProfileViewModel> call(@NonNull String username) {
        checkNotNull(schedulerProvider, "Parameter username cannot be null.");

        return userProvider.getUser(username)
                .map(new UserViewModelMapper())
                .observeOn(schedulerProvider.ui());
    }

    static class UserViewModelMapper implements Func1<User, ProfileViewModel> {

        @Override
        public ProfileViewModel call(User user) {
            return ProfileViewModel.from(user.avatarUrl(), user.login(), user.name(), user.location());
        }
    }
}
