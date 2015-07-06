package com.moac.android.mvpgithubclient.injection.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@Module
public class ConfigModule {

    @Provides
    @Singleton
    @Named(GithubApiModule.URL_CONFIG)
    public String provideGithubApiModuleUrlConfig() {
        return "https://api.github.com/";
    }

}
