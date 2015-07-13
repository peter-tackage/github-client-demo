package com.moac.android.mvpgithubclient.ui.core.view;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author Peter Tackage
 * @since 13/07/15
 *
 * FIXME I'm not 100% convinced about this class, it's good for mocking because fluent APIs make
 * that a little difficult (you would need to mock each chained method) but unless you make this
 * class/interface expose Picasso features (e.g. Target) then you lose some of the benefits of
 * Picasso and get stuck with a lowest common denominator.
 *
 * My compromise is to expose Picasso APIs here by explicitly making it a PicassoImageLoader
 */
public class PicassoImageLoader {

    private final Picasso picasso;

    public PicassoImageLoader(@NonNull Picasso picasso) {
        this.picasso = picasso;
    }

    public void load(@NonNull String path, @NonNull ImageView imageView) {
        picasso.load(path).into(imageView);
    }
}
