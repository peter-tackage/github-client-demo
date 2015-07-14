package com.moac.android.mvpgithubclient.test.core;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;

/**
 * @author Peter Tackage
 * @since 13/07/15
 * <p/>
 * This class won't be necessary once Dexmaker patches issues:
 * https://github.com/crittercism/dexmaker/issues/18 and
 * https://github.com/crittercism/dexmaker/issues/12
 */
public abstract class PatchedDexmakerTestCase {

    @CallSuper
    public void setUp() throws Exception {
        fixDexMaker();
    }

    protected Context getTargetContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    protected Context getContext() {
        return InstrumentationRegistry.getContext();
    }

    private void fixDexMaker() {
        // Patch broken DexMaker
        System.setProperty("dexmaker.dexcache", getTargetContext().getCacheDir().getPath());
    }

}
