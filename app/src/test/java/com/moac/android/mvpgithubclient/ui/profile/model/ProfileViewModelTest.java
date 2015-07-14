package com.moac.android.mvpgithubclient.ui.profile.model;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import java.lang.String;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
public class ProfileViewModelTest {

    private static final String AVATAR_URL = "avatarUrl";
    private static final String USER_NAME = "userName";
    private static final String NAME = "name";
    private static final String LOCATION = "location";

    @Test
    public void testModelValuesAssigned_WhenCreatedUsingFactory() {

        ProfileViewModel profileViewModel =
                ProfileViewModel.from(AVATAR_URL, USER_NAME, NAME, LOCATION);

        assertThat(profileViewModel.avatarUrl()).isEqualTo(AVATAR_URL);
        assertThat(profileViewModel.userName()).isEqualTo(USER_NAME);
        assertThat(profileViewModel.name()).isEqualTo(NAME);
        assertThat(profileViewModel.location()).isEqualTo(LOCATION);
    }

}
