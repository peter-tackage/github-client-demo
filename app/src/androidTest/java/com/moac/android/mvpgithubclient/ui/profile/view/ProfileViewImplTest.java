package com.moac.android.mvpgithubclient.ui.profile.view;

import android.view.View;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.test.core.PatchedAndroidTestCase;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
public class ProfileViewImplTest extends PatchedAndroidTestCase {

    @Mock
    PicassoImageLoader picassoImageLoader;

    @Mock
    ErrorRenderer errorRenderer;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    private View getView() {
        return View.inflate(getContext(), R.layout.activity_profile, null);
    }

    public void testThrowsOnShowContent_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picassoImageLoader, errorRenderer);
        try {
            profileView.showContent(mock(ProfileViewModel.class));
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }

    }

    public void testThrowsOnShowError_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picassoImageLoader, errorRenderer);
        try {
            profileView.showError("dummy");
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }
    }

    public void testThrowsOnShowLoading_WhenContentViewNotSet() {
        ProfileViewImpl profileView = new ProfileViewImpl(picassoImageLoader, errorRenderer);
        try {
            profileView.showLoading();
            fail("IllegalStateException should have been thrown as content view was not set");
        } catch (IllegalStateException ise) { // expected
        }
    }

    public void testErrorRendererShowsShortMsg_WhenShowErrorInvoked() {
        final String errorMsg = "errorMsg";

        // Inflate the view to allow binding of fields
        final View view = getView();
        ProfileViewImpl profileView = new ProfileViewImpl(picassoImageLoader, errorRenderer);

        // Set content view
        profileView.setContentView(view);

        // Invoke showError
        profileView.showError(errorMsg);

        verify(errorRenderer).showShortError(view, errorMsg);
    }

    public void testShowContentDoesNotThrow_WhenContentViewSet() {
        final ProfileViewModel profileViewModel = mock(ProfileViewModel.class);
        ProfileViewImpl profileView = new ProfileViewImpl(picassoImageLoader, errorRenderer);

        // Set content view
        profileView.setContentView(getView());

        // Invoke showContent
        profileView.showContent(profileViewModel);
    }
}
