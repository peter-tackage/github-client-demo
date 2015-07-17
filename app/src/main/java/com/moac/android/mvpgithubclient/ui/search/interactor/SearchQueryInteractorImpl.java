package com.moac.android.mvpgithubclient.ui.search.interactor;

import android.support.annotation.NonNull;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

/**
 * @author Peter Tackage
 * @since 16/07/15
 *
 * Interactor with two way interaction, contains it's own model
 */
public class SearchQueryInteractorImpl implements SearchQueryInteractor {

    @NonNull
    private BehaviorSubject<String> searchQuery = BehaviorSubject.create("");

    @Override
    public void setSearchQuery(@NonNull String query) {
        searchQuery.onNext(query);
    }

    @NonNull
    @Override
    public Observable<String> getSearchQuery() {
        return searchQuery
                .distinct()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
