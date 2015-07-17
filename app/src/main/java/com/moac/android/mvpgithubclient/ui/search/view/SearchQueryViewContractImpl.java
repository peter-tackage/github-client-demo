package com.moac.android.mvpgithubclient.ui.search.view;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.moac.android.mvpgithubclient.injection.module.ForActivity;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * @author Peter Tackage
 * @since 16/07/15
 */
public class SearchQueryViewContractImpl implements SearchQueryViewContract {

    private final Activity activity;
    private Observable<String> searchQueryObservable;

    @Inject
    public SearchQueryViewContractImpl(@ForActivity Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public Observable<String> getSearchQuery() {
        return searchQueryObservable;
    }

    @Override
    public void setSearchView(@NonNull SearchView searchView) {
        initSearchView(searchView);
    }

    private void initSearchView(@NonNull final SearchView searchView) {
        SearchManager searchManager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v == searchView && !hasFocus) searchView.setIconified(true);
            }
        });
        searchQueryObservable = createSearchQueryObservable(searchView);
    }

    private static Observable<String> createSearchQueryObservable(SearchView searchView) {
        return Observable.create(new SearchQueryObservable(searchView));
    }

    // Converts a SearchView listener into a subscriber
    // Note: This only supports a single subscriber per SearchView
    private static class SearchQueryObservable implements Observable.OnSubscribe<String> {

        final SearchView searchView;

        public SearchQueryObservable(SearchView searchView) {
            this.searchView = searchView;
        }


        @Override
        public void call(final Subscriber<? super String> subscriber) {
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    subscriber.onNext(null);
                    return true;
                }
            });

            searchView.setOnQueryTextListener(
                    new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            notify(query);
                            return true;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            notify(newText);
                            return true;
                        }

                        private void notify(String query) {
                            subscriber.onNext(query);
                        }
                    });
        }
    }
}
