package com.moac.android.mvpgithubclient.ui.profile;

import android.os.Bundle;

import com.moac.android.mvpgithubclient.GithubClientApplication;
import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.injection.module.BaseActivityModule;
import com.moac.android.mvpgithubclient.ui.BaseActivity;
import com.moac.android.mvpgithubclient.ui.profile.presenter.ProfilePresenter;
import com.moac.android.mvpgithubclient.ui.profile.view.ProfileViewImpl;

import javax.inject.Inject;

import static com.moac.android.mvpgithubclient.util.ViewUtils.getActivityRootViewId;

public class ProfileActivity extends BaseActivity<ProfileComponent> {

//    @Inject
    ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // TODO Inject ProfileViewImpl via Factory or assisted injection
        profilePresenter.onAttachView(new ProfileViewImpl(findViewById(getActivityRootViewId())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profilePresenter.onDetachView();
    }

    @Override
    public void initComponent() {
        if (component == null) {
//            component = DaggerProfileComponent.builder()
//                    .baseApplicationComponent(((GithubClientApplication) getApplication()).component())
//                    .baseActivityModule(new BaseActivityModule(this))
//                    .build();
        }
    }
}
