package com.moac.android.mvpgithubclient.ui.profile.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.util.Preconditions;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class ProfileViewImpl implements ProfileView {

    private final Picasso picasso;
    private final ErrorRenderer errorRenderer;
    private View contentView;

    @Bind(R.id.imageView_avatar) ImageView avatarImageView;
    @Bind(R.id.textView_name) TextView nameTextView;
    @Bind(R.id.textView_username) TextView usernameTextView;
    @Bind(R.id.textView_location) TextView locationTextView;

    public ProfileViewImpl(Picasso picasso, ErrorRenderer errorRenderer) {
        this.picasso = picasso;
        this.errorRenderer = errorRenderer;
    }

    @Override
    public void setContentView(View contentView) {
        this.contentView = contentView;
        ButterKnife.bind(this, contentView);
    }

    @Override
    public void showLoading() {
        checkContentViewIsSet();
    }

    @Override
    public void showContent(ProfileViewModel profileViewModel) {
        checkContentViewIsSet();
        picasso.load(profileViewModel.avatarUrl()).into(avatarImageView);
        nameTextView.setText(profileViewModel.name());
        usernameTextView.setText(profileViewModel.userName());
        locationTextView.setText(profileViewModel.location());
    }

    @Override
    public void showError(String msg) {
        checkContentViewIsSet();
        errorRenderer.showShortError(contentView, msg);
    }

    private void checkContentViewIsSet() {
        Preconditions.checkNotNull(contentView, "Content view has not been set");
    }

}
