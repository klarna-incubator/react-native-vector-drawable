package com.klarna.vectordrawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.facebook.react.common.JavascriptException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.ThemedReactContext;

import javax.annotation.Nullable;

public class VectorDrawableManagerImpl {

    public static final String NAME = "RNVectorDrawable";

    public static ImageView createViewInstance(ThemedReactContext context) {
        ImageView view = new ImageView(context);
        view.setCropToPadding(true);
        view.setScaleType(toScaleType(null));
        return view;
    }

    public static void setResourceName(ImageView view, @Nullable String resourceName) {
        Drawable draw = createVectorDrawable(view.getContext(), resourceName);
        view.setImageDrawable(draw);
    }

    public static void setTintColor(ImageView view, @Nullable Integer tintColor) {
        if (tintColor == null) {
            view.clearColorFilter();
        } else {
            view.setColorFilter(tintColor, Mode.SRC_IN);
        }
    }

    public static void setResizeMode(ImageView view, @Nullable String resizeMode) {
        view.setScaleType(toScaleType(resizeMode));
    }

    private static final String RESIZE_MODE_CONTAIN = "contain";
    private static final String RESIZE_MODE_COVER = "cover";
    private static final String RESIZE_MODE_STRETCH = "stretch";
    private static final String RESIZE_MODE_CENTER = "center";
    private static ScaleType toScaleType(@Nullable String resizeModeValue) {
        if (resizeModeValue == null || RESIZE_MODE_COVER.equals(resizeModeValue)) {
            return ScaleType.CENTER_CROP;
        }
        if (RESIZE_MODE_CONTAIN.equals(resizeModeValue)) {
            return ScaleType.FIT_CENTER;
        }
        if (RESIZE_MODE_STRETCH.equals(resizeModeValue)) {
            return ScaleType.FIT_XY;
        }
        if (RESIZE_MODE_CENTER.equals(resizeModeValue)) {
            return ScaleType.CENTER_INSIDE;
        }

        throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + resizeModeValue + "'");
    }

    private static Drawable createVectorDrawable(Context context, String resourceName) throws JavascriptException {
        int resourceIdent;
        String packageName = context.getPackageName();
        resourceIdent = context.getResources()
                               .getIdentifier(resourceName, "drawable", packageName);
        if (resourceIdent == 0) {
            resourceIdent = context.getResources()
                                   .getIdentifier(resourceName, "drawable-hdpi", packageName);
        }
        if (resourceIdent == 0) {
            throw new JavascriptException("Unable to find resource " + resourceName + " in " + packageName);
        }

        return ContextCompat.getDrawable(context, resourceIdent);
    }
}
