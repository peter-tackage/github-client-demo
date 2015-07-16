package com.moac.android.mvpgithubclient.ui.profile.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import rx.Observable;

/**
 * @author Peter Tackage
 * @since 13/07/15
 *
 * Interactors supply formatted data to the Presenter on the appropriate thread for visualization.
 *
 * The functional naming convention is used to abstract the result from the data source
 */
public interface GetUserProfile {

    @NonNull
    Observable<ProfileViewModel> call(@NonNull String username);
}
