package com.moac.android.mvpgithubclient.ui.core.presenter;

import android.support.annotation.CallSuper;

import rx.Observer;
import timber.log.Timber;

import static com.moac.android.mvpgithubclient.util.Preconditions.checkOnMainThread;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class ContentObserver<T> implements Observer<T> {

    @Override
    @CallSuper
    public void onCompleted() {
        Timber.v("OnCompleted");
        checkOnMainThread();
    }

    @Override
    @CallSuper
    public void onError(Throwable e) {
        Timber.e("OnError", e);
        checkOnMainThread();
    }

    @Override
    @CallSuper
    public void onNext(T content) {
        Timber.v("onNext", content.toString());
        checkOnMainThread();
    }
}
