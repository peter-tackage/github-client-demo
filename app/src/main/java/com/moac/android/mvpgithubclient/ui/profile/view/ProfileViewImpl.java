package com.moac.android.mvpgithubclient.ui.profile.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.moac.android.mvpgithubclient.util.Preconditions;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class ProfileViewImpl implements ProfileView {

    @NonNull private final PicassoImageLoader picasso;
    @NonNull private final ErrorRenderer errorRenderer;
    private View contentView;

    @Bind(R.id.imageView_avatar) ImageView avatarImageView;
    @Bind(R.id.textView_name) TextView nameTextView;
    @Bind(R.id.textView_username) TextView usernameTextView;
    @Bind(R.id.textView_location) TextView locationTextView;

    public ProfileViewImpl(@NonNull PicassoImageLoader picasso,
                           @NonNull ErrorRenderer errorRenderer) {
        this.picasso = picasso;
        this.errorRenderer = errorRenderer;
    }

    @Override
    public void setContentView(@NonNull View contentView) {
        Preconditions.checkNotNull(contentView, "Content View cannot be null");
        this.contentView = contentView;
        ButterKnife.bind(this, contentView);
    }

    @Override
    public void showLoading() {
        checkContentViewIsSet();
    }

    @Override
    public void showContent(@NonNull ProfileViewModel profileViewModel) {
        checkContentViewIsSet();
        picasso.load(profileViewModel.avatarUrl(), avatarImageView);
        nameTextView.setText(profileViewModel.name());
        usernameTextView.setText(profileViewModel.userName());
        locationTextView.setText(profileViewModel.location());
    }

    @Override
    public void showError(@NonNull String msg) {
        checkContentViewIsSet();
        errorRenderer.showShortError(contentView, msg);
    }

    private void checkContentViewIsSet() {
        Preconditions.checkNotNull(contentView, "Content view has not been set");
    }

}
