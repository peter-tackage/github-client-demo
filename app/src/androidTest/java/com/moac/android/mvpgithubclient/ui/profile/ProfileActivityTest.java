package com.moac.android.mvpgithubclient.ui.profile;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Peter Tackage
 * @since 13/07/15
 */
@RunWith(AndroidJUnit4.class)
public class ProfileActivityTest {

    private ActivityTestRule<ProfileActivity> rule = new ActivityTestRule<>(ProfileActivity.class);

    private ProfileActivity activity;

    @Before
    public void setUp() {
        activity = rule.getActivity();
    }

    @After
    public void tearDown() {
        activity = null;
    }

    @Test
    public void checkPreconditions() {
//        assertThat(activity).isNotNull();
    }

    @Test
    public void loadData() {
//        String tag = "1. Root view visible, progress bar showing";
//        onView(isRoot()).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        tag = "2. Grid shown with images loaded";
//        // TODO: remove wait delay, use RxJava's TestScheduler or Espresso.registerIdlingResource
//        onView(isRoot()).perform(ViewActions.waitAtLeast(Constants.WAIT_DELAY));
//        onView(withId(R.id.gallery_grid)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }


}
