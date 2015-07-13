package com.moac.android.mvpgithubclient.test.core;

import android.support.annotation.CallSuper;
import android.test.AndroidTestCase;

/**
 * @author Peter Tackage
 * @since 13/07/15
 *
 * AndroidTestCase patched for issues with dexmaker < 1.3+
 */
public class PatchedAndroidTestCase extends AndroidTestCase {

    @Override
    @CallSuper
    public void setUp() throws Exception {
        super.setUp();
        fixDexMaker();
    }

    // FIXME Remove once upgrade to dexmaker 1.3 is possible
    private void fixDexMaker() {
        // Patch broken DexMaker
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());
    }

}
