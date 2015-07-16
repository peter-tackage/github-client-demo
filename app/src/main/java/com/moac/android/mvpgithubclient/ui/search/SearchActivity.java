package com.moac.android.mvpgithubclient.ui.search;

import android.os.Bundle;

import com.moac.android.mvpgithubclient.GithubClientApplication;
import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.ui.BaseActivity;
import com.moac.android.mvpgithubclient.ui.search.presenter.SearchResultPresenter;
import com.moac.android.mvpgithubclient.ui.search.view.SearchResultViewContract;

import javax.inject.Inject;

import static com.moac.android.mvpgithubclient.util.ViewUtils.getActivityRootViewId;

public class SearchActivity extends BaseActivity<SearchComponent> {

    @Inject
    SearchResultPresenter searchResultPresenter;

    @Inject
    SearchResultViewContract searchResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component.inject(this);
        setContent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchResultPresenter.onViewDestroyed();
        searchResultPresenter = null;
        searchResultView = null;
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
}
