package com.moac.android.mvpgithubclient.injection.module;

import com.moac.android.mvpgithubclient.api.GithubApi;
import com.moac.android.mvpgithubclient.provider.SearchProvider;
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
    UserProvider providerUserProvider(GithubApi githubApi) {
        return new UserProvider(githubApi);
    }

    @Provides
    @Singleton
    SearchProvider providerSearchProvider(GithubApi githubApi) {
        return new SearchProvider(githubApi);
    }
}
