package com.moac.android.mvpgithubclient.injection.module;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moac.android.mvpgithubclient.api.GithubApi;
import com.moac.android.mvpgithubclient.api.autovalue.AutoGsonTypeAdapter;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * @author Peter Tackage
 * @since 06/07/15
 */
@Module(includes = {ConfigModule.class, InstrumentationModule.class})
public class GithubApiModule {

    static final String URL_CONFIG = "GithubApiModule.URL_CONFIG";

    @Provides
    @NonNull
    @Singleton
    GithubApi provideGithubSearchApi(Endpoint endpoint,
                                     Client client,
                                     Converter converter) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setClient(client)
                .setConverter(converter)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(GithubApi.class);
    }

    // Internal //

    @Provides
    @NonNull
    @Singleton
    Endpoint provideEndpoint(@Named(URL_CONFIG) String url) {
        return Endpoints.newFixedEndpoint(url);
    }

    @Provides
    @NonNull
    @Singleton
    OkHttpClient provideApiOkHttpClient(@AppInterceptors List<Interceptor> appInterceptor,
                                        @NetworkInterceptors List<Interceptor> networkInterceptor) {
        return createOkHttpClient(appInterceptor, networkInterceptor);
    }


    @Provides
    @NonNull
    @Singleton
    Client provideClient(OkHttpClient okHttpClient) {
        return new OkClient(okHttpClient);
    }

    @Provides
    @NonNull
    @Singleton
    Converter provideConverter(Gson gson) {
        return new GsonConverter(gson);
    }

    @Provides
    @NonNull
    @Singleton
    Gson provideGson() {
        return createGson();
    }

    @NonNull
    private static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new AutoGsonTypeAdapter())
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @NonNull
    private static OkHttpClient createOkHttpClient(List<Interceptor> appInterceptors,
                                                   List<Interceptor> networkInterceptors) {
        OkHttpClient client = new OkHttpClient();

        // Install interceptors
        client.interceptors().addAll(appInterceptors);
        client.networkInterceptors().addAll(networkInterceptors);

        return client;
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AppInterceptors {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NetworkInterceptors {
    }

}
