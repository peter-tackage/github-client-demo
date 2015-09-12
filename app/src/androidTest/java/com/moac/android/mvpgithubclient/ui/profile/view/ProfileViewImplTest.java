package com.moac.android.mvpgithubclient.ui.profile.view;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import com.moac.android.mvpgithubclient.R;
import com.moac.android.mvpgithubclient.test.core.PatchedDexmakerTestCase;
import com.moac.android.mvpgithubclient.ui.core.view.ErrorRenderer;
import com.moac.android.mvpgithubclient.ui.core.view.PicassoImageLoader;
import com.moac.android.mvpgithubclient.ui.profile.model.ProfileViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class ProfileViewImplTest extends PatchedDexmakerTestCase {

    @Mock
    PicassoImageLoader picassoImageLoader;

    @Mock
    ErrorRenderer errorRenderer;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_checkPreconditions() {
        assertThat(picassoImageLoader).isNotNull();
        assertThat(errorRenderer).isNotNull();
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowsOnShowContent_WhenContentViewNotSet() {
        ProfileViewContractImpl profileView = new ProfileViewContractImpl(picassoImageLoader,
                errorRenderer);
        profileView.showContent(mock(ProfileViewModel.class));
        fail("IllegalStateException should have been thrown as content view was not set");
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowsOnShowError_WhenContentViewNotSet() {
        ProfileViewContractImpl profileView = new ProfileViewContractImpl(picassoImageLoader,
                errorRenderer);
        profileView.showError("dummy");
        fail("IllegalStateException should have been thrown as content view was not set");
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowsOnShowLoading_WhenContentViewNotSet() {
        ProfileViewContractImpl profileView = new ProfileViewContractImpl(picassoImageLoader,
                errorRenderer);
        profileView.showLoading();
        fail("IllegalStateException should have been thrown as content view was not set");
    }

    @Test
    public void testErrorRendererShowsShortMsg_WhenShowErrorInvoked() {
        final String errorMsg = "errorMsg";

        // Inflate the view to allow binding of fields
        final View view = getView();
        ProfileViewContractImpl profileView = new ProfileViewContractImpl(picassoImageLoader,
                errorRenderer);

        // Set content view
        profileView.setContentView(view);

        // Invoke showError
        profileView.showError(errorMsg);

        verify(errorRenderer).showShortError(view, errorMsg);
    }

    @Test
    public void testShowContentDoesNotThrow_WhenContentViewSet() {
        final ProfileViewModel profileViewModel = mock(ProfileViewModel.class);
        ProfileViewContractImpl profileView = new ProfileViewContractImpl(picassoImageLoader,
                errorRenderer);

        // Set content view
        profileView.setContentView(getView());

        // Invoke showContent
        profileView.showContent(profileViewModel);
    }

    /**
     * Defines the layout used by View implementation.
     */
    private View getView() {
        return View.inflate(getTargetContext(), R.layout.activity_profile, null);
    }

}
