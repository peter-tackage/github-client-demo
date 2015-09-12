package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import com.moac.android.mvpgithubclient.scheduler.SchedulerProvider;

import rx.Observable;
import rx.subjects.BehaviorSubject;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

/**
 * <p/>
 * Interactor with two way interaction, contains it's own model as a BehaviorSubject.
 * <p/>
 * TODO Perhaps This should contain a constructor to allow the setting of the default searchQuery
 * value. This might be necessary when handling configuration changes.
 */
public class SearchQueryInteractorImpl implements SearchQueryInteractor {

    @NonNull private final SchedulerProvider schedulerProvider;

    @NonNull
    private final BehaviorSubject<String> searchQuery = BehaviorSubject.create("");

    public SearchQueryInteractorImpl(@NonNull SchedulerProvider schedulerProvider) {
        checkNotNull(schedulerProvider, "Parameter schedulerProvider cannot be null.");

        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void setSearchQuery(@NonNull String query) {
        checkNotNull(schedulerProvider, "Parameter query cannot be null.");

        searchQuery.onNext(query);
    }

    @NonNull
    @Override
    public Observable<String> getSearchQuery() {
        return searchQuery
                .distinctUntilChanged()
                .observeOn(schedulerProvider.ui());
    }
}
