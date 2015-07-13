package com.moac.android.mvpgithubclient.ui.profile.presenter;

import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.profile.interactor.UserModelInteractor;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileView;

import rx.Subscription;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    private final UserModelInteractor userModelInteractor;

    private Subscription userSubscription;

    public ProfilePresenterImpl(UserModelInteractor userModelInteractor) {
        this.userModelInteractor = userModelInteractor;
    }

    @Override
    public void onViewCreated(final ProfileView profileView) {
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
