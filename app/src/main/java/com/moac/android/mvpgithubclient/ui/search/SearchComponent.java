package com.moac.android.mvpgithubclient.ui.search;

import com.moac.android.mvpgithubclient.GithubClientApplicationComponent;
import com.moac.android.mvpgithubclient.injection.component.BaseActivityComponent;
import com.moac.android.mvpgithubclient.injection.component.PerActivity;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.injection.module.PresenterModule;
import com.moac.android.mvpgithubclient.injection.module.ViewModule;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchQueryPresenter;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchResultPresenter;
import com.moac.android.mvpgithubclient.ui.search.view.SearchQueryViewContract;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;

import dagger.Component;

/**
 * @author Peter Tackage
 * @since 16/04/15
 */

@PerActivity
@Component(dependencies = GithubClientApplicationComponent.class,
        modules = {BaseActivityModule.class, PresenterModule.class, ViewModule.class})
public interface SearchComponent extends BaseActivityComponent {

    SearchResultPresenter provideSearchResultPresenter();

    SearchResultViewContract provideSearchResultViewContract();

    SearchQueryPresenter provideSearchQueryPresenter();

    SearchQueryViewContract provideSearchQueryViewContract();

    void inject(SearchActivity profileActivity);

}
