package com.moac.android.mvpgithubclient.ui.profile.presenter;

import com.moac.android.mvpgithubclient.provider.UserProvider;
import com.moac.android.mvpgithubclient.ui.core.presenter.ContentObserver;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.ui.profile.model.UserViewModelMapper;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    private final UserProvider userProvider;

    private Subscription userSubscription;

    public ProfilePresenterImpl(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void onAttachView(final ProfileView profileView) {
        userSubscription = userProvider.getUser("peter-tackage")
                .map(new UserViewModelMapper())
                .observeOn(AndroidSchedulers.mainThread())
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
    public void onDetachView() {
        userSubscription.unsubscribe();
    }
}
