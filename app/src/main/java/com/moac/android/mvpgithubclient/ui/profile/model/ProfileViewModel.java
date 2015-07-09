package com.moac.android.mvpgithubclient.ui.profile.model;

import com.google.auto.value.AutoValue;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
@AutoValue
public abstract class ProfileViewModel {
    abstract String avatarUrl();

    abstract String userName();

    abstract String name();

    abstract String location();

    public static ProfileViewModel from(String avatarUrl, String username,
                                        String name, String location) {
        return new AutoValue_ProfileViewModel(avatarUrl, username, name, location);
    }
}
