package com.moac.android.mvpgithubclient.ui.core.presenter;

import android.support.annotation.CallSuper;

import rx.Observer;
import timber.log.Timber;

/**
 * @author Peter Tackage
 * @since 08/07/15
 */
public class ContentObserver<T> implements Observer<T> {

    @Override
    @CallSuper
    public void onCompleted() {
        Timber.v("OnCompleted");
    }

    @Override
    @CallSuper
    public void onError(Throwable e) {
        Timber.e("OnError", e);
    }

    @Override
    @CallSuper
    public void onNext(T content) {
        Timber.v("onNext", content.toString());
    }
}
