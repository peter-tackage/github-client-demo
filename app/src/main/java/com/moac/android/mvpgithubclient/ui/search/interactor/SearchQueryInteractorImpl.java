package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

/**
 * @author Peter Tackage
 * @since 16/07/15
 * <p/>
 * Interactor with two way interaction, contains it's own model as a BehaviorSubject.
 *
 * TODO Perhaps This should contain a constructor to allow the setting of the default searchQuery
 * value. This might be necessary when handling configuration changes.
 */
public class SearchQueryInteractorImpl implements SearchQueryInteractor {

    @NonNull private final Scheduler observeOn;

    @NonNull
    private final BehaviorSubject<String> searchQuery = BehaviorSubject.create("");

    public SearchQueryInteractorImpl() {
        this.observeOn = AndroidSchedulers.mainThread();
    }

    @VisibleForTesting
    public SearchQueryInteractorImpl(@NonNull Scheduler observeOn) {
        this.observeOn = observeOn;
    }

    @Override
    public void setSearchQuery(@NonNull String query) {
        searchQuery.onNext(query);
    }

    @NonNull
    @Override
    public Observable<String> getSearchQuery() {
        return searchQuery
                .distinctUntilChanged()
                .observeOn(observeOn);
    }
}
