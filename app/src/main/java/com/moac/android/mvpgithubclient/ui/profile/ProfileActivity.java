package com.moac.android.mvpgithubclient.ui.profile;

import android.os.Bundle;

import com.moac.android.mvpgithubclient.GithubClientApplication;
import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.injection.module.ActivityModule;
import com.moac.android.mvpgithubclient.ui.BaseActivity;

public class ProfileActivity extends BaseActivity<ProfileComponent> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void initComponent() {
        if (component == null) {
            component = DaggerProfileComponent.builder()
                    .baseApplicationComponent(((GithubClientApplication) getApplication()).component())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
    }
}
