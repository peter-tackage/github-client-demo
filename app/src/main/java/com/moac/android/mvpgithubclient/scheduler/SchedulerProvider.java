package com.moac.android.mvpgithubclient.scheduler;

import android.support.annotation.NonNull;

import rx.Scheduler;

public interface SchedulerProvider {

    @NonNull
    Scheduler immediate();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler ui();

}
