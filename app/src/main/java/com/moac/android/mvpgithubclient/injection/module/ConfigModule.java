package com.moac.android.mvpgithubclient.injection.module;

import android.support.annotation.NonNull;

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
    @NonNull
    @Singleton
    @Named(GithubApiModule.URL_CONFIG)
    public String provideGithubApiModuleUrlConfig() {
        return "https://api.github.com/";
    }

}
