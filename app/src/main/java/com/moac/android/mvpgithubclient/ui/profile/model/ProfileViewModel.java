package com.moac.android.mvpgithubclient.ui.profile.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
@AutoValue
public abstract class ProfileViewModel {

    @NonNull public abstract String avatarUrl();

    @NonNull public abstract String userName();

    @NonNull public abstract String name();

    @NonNull public abstract String location();

    @NonNull public static ProfileViewModel from(String avatarUrl, String username,
                                        String name, String location) {
        return new AutoValue_ProfileViewModel(avatarUrl, username, name, location);
    }
}
