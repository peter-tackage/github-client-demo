package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.api.GithubUserApi;
import com.moac.android.mvpgithubclient.provider.UserProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Peter Tackage
 * @since 16/04/15
 */
@Module(includes = GithubApiModule.class)
public class DataModule {
    @Provides
    @Singleton
    UserProvider providerUserProvider(GithubUserApi githubUserApi) {
        return new UserProvider(githubUserApi);
    }
}
