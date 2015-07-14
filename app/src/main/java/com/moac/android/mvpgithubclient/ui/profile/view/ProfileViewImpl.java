package com.moac.android.mvpgithubclient.ui.profile.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkNotNull;

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

    public ProfileViewImpl(@NonNull PicassoImageLoader picassoImageLoader,
                           @NonNull ErrorRenderer errorRenderer) {
        checkNotNull(picassoImageLoader, "Parameter picassoImageLoader cannot be null.");
        checkNotNull(errorRenderer, "Parameter errorRenderer cannot be null.");

        this.picasso = picassoImageLoader;
        this.errorRenderer = errorRenderer;
    }

    @Override
    public void setContentView(@NonNull View contentView) {
        checkNotNull(contentView, "Parameter contentView cannot be null.");
        this.contentView = contentView;
        ButterKnife.bind(this, contentView);
    }

    @Override
    public void showLoading() {
        checkContentViewIsSet();
    }

    @Override
    public void showContent(@NonNull ProfileViewModel profileViewModel) {
        checkNotNull(profileViewModel, "Parameter profileViewModel cannot be null.");
        checkContentViewIsSet();

        // Populate the view
        picasso.load(profileViewModel.avatarUrl(), avatarImageView);
        nameTextView.setText(profileViewModel.name());
        usernameTextView.setText(profileViewModel.userName());
        locationTextView.setText(profileViewModel.location());
    }

    @Override
    public void showError(@NonNull String msg) {
        checkContentViewIsSet();

        // Display error message
        errorRenderer.showShortError(contentView, msg);
    }

    private void checkContentViewIsSet() {
        checkNotNull(contentView, "Content view has not been set.");
    }

}
