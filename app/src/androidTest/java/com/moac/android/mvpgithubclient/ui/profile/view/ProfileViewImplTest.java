package com.moac.android.mvpgithubclient.ui.profile.view;

import com.moac.android.mvpgithubclient.test.core.PatchedAndroidTestCase;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;
import com.squareup.picasso.Picasso;

import org.mockito.Mock;

import static org.mockito.Matchers.any;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class ProfileViewImplTest extends PatchedAndroidTestCase {

    @Mock
    Picasso picasso;

    @Mock
    ErrorRenderer errorRenderer;

    public void testThrowsOnShowContent_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picasso, errorRenderer);

        try {
            profileView.showContent(any(ProfileViewModel.class));
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }

    }

    public void testThrowsOnShowError_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picasso, errorRenderer);

        try {
            profileView.showError(any(String.class));
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }
    }

    public void testThrowsOnShowLoading_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picasso, errorRenderer);
        try {
            profileView.showLoading();
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }
    }

}
