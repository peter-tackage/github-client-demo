package com.moac.android.mvpgithubclient.ui.core.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * @author Peter Tackage
 * @since 17/07/15
 */
public class CircleImageTransformation implements Transformation {
    private static final String KEY = "circle";

    @Override
    public Bitmap transform(Bitmap source) {

        Bitmap roundEdgeBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        Canvas c = new Canvas(roundEdgeBitmap);
        int shortestAxis = Math.min(source.getWidth(), source.getHeight());
        c.drawCircle(source.getWidth() / 2, source.getHeight() / 2, (float) shortestAxis / 2f, paint);

        if (roundEdgeBitmap != source) {
            source.recycle();
        }
        return roundEdgeBitmap;
    }

    @Override
    public String key() {
        return KEY;
    }
}
