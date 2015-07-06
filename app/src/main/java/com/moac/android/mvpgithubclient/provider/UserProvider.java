package com.moac.android.mvpgithubclient.provider;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
public class UserProvider {
    private final UserService userService;

    public UserProvider(UserService userService) {
        this.userService = userService;
    }
}
