package com.moac.android.mvpgithubclient.ui.profile.presenter;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractor;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;

import rx.Subscription;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    @NonNull private final UserModelInteractor userModelInteractor;

    private Subscription userSubscription;

    public ProfilePresenterImpl(@NonNull UserModelInteractor userModelInteractor) {
        checkNotNull(userModelInteractor, "Parameter userModelInteractor cannot be null.");
        this.userModelInteractor = userModelInteractor;
    }

    @Override
    public void onViewCreated(@NonNull final ProfileViewContract profileView) {
        userSubscription = userModelInteractor.getProfileViewModel("peter-tackage")
                .subscribe(new ContentObserver<ProfileViewModel>() {
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        // TODO Differentiate between error types
                        profileView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ProfileViewModel profileViewModel) {
                        super.onNext(profileViewModel);
                        profileView.showContent(profileViewModel);
                    }
                });
    }

    @Override
    public void onViewDestroyed() {
        userSubscription.unsubscribe();
    }
}
