package com.moac.android.mvpgithubclient.ui.profile.model;

import android.test.suitebuilder.annotation.SmallTest;

import com.moac.android.mvpgithubclient.api.model.User;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@SmallTest
public class UserViewModelMapperTest {

    private static final String AVATAR_URL = "avatarUrl";
    private static final String LOGIN = "login";
    private static final String NAME = "name";
    private static final String LOCATION = "location";

    @Test
    public void testModelValueAssigned_WhenCreatedUsingFactory() {

        User mockUser = mock(User.class);
        when(mockUser.avatarUrl()).thenReturn(AVATAR_URL);
        when(mockUser.login()).thenReturn(LOGIN);
        when(mockUser.name()).thenReturn(NAME);
        when(mockUser.location()).thenReturn(LOCATION);
        UserViewModelMapper modelMapper = new UserViewModelMapper();

        ProfileViewModel profileViewModel = modelMapper.call(mockUser);

        assertThat(profileViewModel.avatarUrl()).isEqualTo(AVATAR_URL);
        assertThat(profileViewModel.userName()).isEqualTo(LOGIN);
        assertThat(profileViewModel.name()).isEqualTo(NAME);
        assertThat(profileViewModel.location()).isEqualTo(LOCATION);
    }

}
