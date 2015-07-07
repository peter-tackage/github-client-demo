package com.moac.android.mvpgithubclient.injection.module;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@Module
public class InstrumentationModule {

    @Provides
    @Singleton
    @GithubApiModule.NetworkInterceptors
    List<Interceptor> provideNetworkInterceptors() {
        ArrayList<Interceptor> networkInterceptors = new ArrayList<>();
        networkInterceptors.add(new StethoInterceptor());
        return networkInterceptors;
    }

    @Provides
    @Singleton
    @GithubApiModule.AppInterceptors
    List<Interceptor> provideAppInterceptors() {
        return Collections.emptyList();
    }
}
