package com.moac.android.mvpgithubclient.test;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class TestSchedulerProvider implements SchedulerProvider {

    private Scheduler immediate;
    private Scheduler io;
    private Scheduler computation;
    private Scheduler ui;

    private TestSchedulerProvider(Scheduler immediate,
                                  Scheduler io,
                                  Scheduler computation,
                                  Scheduler ui) {

        this.immediate = immediate;
        this.io = io;
        this.computation = computation;
        this.ui = ui;
    }

    @NonNull
    @Override
    public Scheduler immediate() {
        return immediate;
    }

    @NonNull
    @Override
    public Scheduler io() {
        return io;
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return computation;
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return ui;
    }

    public static class Builder {
        private Scheduler immediate;
        private Scheduler io;
        private Scheduler computation;
        private Scheduler ui;

        public Builder() {
            this.immediate = Schedulers.immediate();
            this.io = Schedulers.immediate();
            this.computation = Schedulers.immediate();
            this.ui = Schedulers.immediate();
        }

        public Builder immediate(Scheduler scheduler) {
            immediate = scheduler;
            return this;
        }

        public Builder io(Scheduler scheduler) {
            io = scheduler;
            return this;
        }

        public Builder computation(Scheduler scheduler) {
            computation = scheduler;
            return this;
        }

        public Builder ui(Scheduler scheduler) {
            ui = scheduler;
            return this;
        }

        public TestSchedulerProvider create() {
            return new TestSchedulerProvider(immediate, io, computation, ui);
        }
    }
}
