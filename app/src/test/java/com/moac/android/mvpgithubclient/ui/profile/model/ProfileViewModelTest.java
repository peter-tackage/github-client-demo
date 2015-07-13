package com.moac.android.mvpgithubclient.ui.profile.model;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
public class ProfileViewModelTest {

    @Test
    public void testModelValuesAssigned_WhenCreatedUsingFactory() {

        ProfileViewModel profileViewModel =
                ProfileViewModel.from("avatarUrl", "userName", "name", "location");

        assertThat(profileViewModel.avatarUrl()).isEqualTo("avatarUrl");
        assertThat(profileViewModel.userName()).isEqualTo("userName");
        assertThat(profileViewModel.name()).isEqualTo("name");
        assertThat(profileViewModel.location()).isEqualTo("location");

    }

}
