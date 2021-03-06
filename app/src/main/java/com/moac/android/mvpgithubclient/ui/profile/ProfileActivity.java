package com.moac.android.mvpgithubclient.ui.profile;

import android.os.Bundle;

import com.moac.android.mvpgithubclient.GithubClientApplication;
import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.ui.BaseActivity;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewContract;

import javax.inject.Inject;

import static com.moac.android.mvpgithubclient.util.ViewUtils.getActivityRootViewId;

public class ProfileActivity extends BaseActivity<ProfileComponent> {

    @Inject
    ProfilePresenter profilePresenter;

    @Inject
    ProfileViewContract profileViewContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component.inject(this);
        setContent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profilePresenter.unbindView();
    }

    @Override
    public void initComponent() {
        if (component == null) {
            component = DaggerProfileComponent.builder()
                    .githubClientApplicationComponent(((GithubClientApplication) getApplication()).component())
                    .baseActivityModule(new BaseActivityModule(this))
                    .build();
        }
    }

    private void setContent() {
        setContentView(R.layout.activity_profile);
        profileViewContract.setContentView(findViewById(getActivityRootViewId()));
        profilePresenter.bindView(profileViewContract);
    }
}
