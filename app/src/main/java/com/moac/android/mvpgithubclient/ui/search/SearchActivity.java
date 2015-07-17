package com.moac.android.mvpgithubclient.ui.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.moac.android.mvpgithubclient.GithubClientApplication;
import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.ui.BaseActivity;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchQueryPresenter;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchResultPresenter;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;

import javax.inject.Inject;

import static com.moac.android.mvpgithubclient.util.ViewUtils.getActivityRootViewId;

public class SearchActivity extends BaseActivity<SearchComponent> {

    @Inject SearchResultPresenter searchResultPresenter;
    @Inject SearchResultViewContract searchResultView;

    @Inject SearchQueryPresenter searchQueryPresenter;
    @Inject SearchQueryViewContract searchQueryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component.inject(this);
        setContent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroySearchQuery();
        destroySearchResult();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        // Get the SearchView, pass to SearchViewContract for manipulation
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchQueryView.setSearchView(searchView);
        searchQueryPresenter.onViewCreated(searchQueryView);

        return true;
    }

    @Override
    public void initComponent() {
        if (component == null) {
            component = DaggerSearchComponent.builder()
                    .githubClientApplicationComponent(((GithubClientApplication) getApplication()).component())
                    .baseActivityModule(new BaseActivityModule(this))
                    .build();
        }
    }

    private void setContent() {
        setContentView(R.layout.activity_search);
        searchResultView.setContentView(findViewById(getActivityRootViewId()));
        searchResultPresenter.onViewCreated(searchResultView);
    }

    private void destroySearchQuery() {
        searchQueryPresenter.onViewDestroyed();
        searchQueryView = null;
        searchQueryView = null;
    }

    private void destroySearchResult() {
        searchResultPresenter.onViewDestroyed();
        searchResultPresenter = null;
        searchResultView = null;
    }
}
