package com.moac.android.mvpgithubclient.ui.profile.presenter;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.profile.interactor.GetUserProfile;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;

import rx.Subscription;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    @NonNull private final GetUserProfile getUserProfile;

    private Subscription userSubscription;

    public ProfilePresenterImpl(@NonNull GetUserProfile getUserProfile) {
        checkNotNull(getUserProfile, "Parameter userModelInteractor cannot be null.");
        this.getUserProfile = getUserProfile;
    }

    @Override
    public void bindView(@NonNull final ProfileViewContract profileView) {
        userSubscription = getUserProfile.call("peter-tackage")
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
    public void unbindView() {
        userSubscription.unsubscribe();
    }
}
