package com.moac.android.mvpgithubclient.api.autovalue;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * @author Peter Tackage
 * @since 07/07/15
 */
public class AutoGsonTypeAdapter implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (!rawType.isAnnotationPresent(AutoGson.class)) {
            // This adapter only supports AutoGson annotated types, so skip.
            return null;
        }

        // Extract the AutoValue implementation class from the annotation and
        // pass that to the default type adapter, other implementations use a hardcoded
        // class prefix ("AutoValue_") which does not work when class names are obfuscated.
        AutoGson autoGson = rawType.getAnnotation(AutoGson.class);

        // Annotations don't allow generic type parameters, unchecked cast is necessary.
        //noinspection unchecked
        return (TypeAdapter<T>) gson.getAdapter(autoGson.autoValueClass());
    }
}
