package com.moac.android.mvpgithubclient.ui.search.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.api.model.User;
import com.moac.android.mvpgithubclient.api.model.UserSearchResult;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.search.renderer.UserListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Peter Tackage
 * @since 14/07/15
 */
public class SearchResultViewContractImpl implements SearchResultViewContract {

    private final ErrorRenderer errorRenderer;
    private final UserListAdapter adapter;
    private View contentView;

    @Bind(R.id.listView_searchResults) ListView searchResultsListView;
    @Bind(R.id.initial) View initialView;
    @Bind(R.id.loading) View loadingView;
    @Bind(R.id.empty) View emptyView;

    public SearchResultViewContractImpl(Context context, PicassoImageLoader picassoImageLoader, ErrorRenderer errorRenderer) {
        this.errorRenderer = errorRenderer;
        this.adapter = new UserListAdapter(context, picassoImageLoader);
    }

    @Override
    public void setContentView(@NonNull View contentView) {
        this.contentView = contentView;
        ButterKnife.bind(this, contentView);
        searchResultsListView.setAdapter(adapter);
        showInitial();
    }

    @Override
    public void showEmpty() {
        searchResultsListView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        initialView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        searchResultsListView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        initialView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContent(@NonNull UserSearchResult content) {
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        initialView.setVisibility(View.GONE);
        searchResultsListView.setVisibility(View.VISIBLE);
        setContent(content.items());
    }

    @Override
    public void showInitial() {
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        searchResultsListView.setVisibility(View.GONE);
        initialView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(@NonNull String msg) {
        errorRenderer.showShortError(contentView, msg);
    }

    private void setContent(List<User> items) {
        adapter.setItems(items);
    }
}
