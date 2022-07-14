package com.klarna.vectordrawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import androidx.core.content.ContextCompat;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.module.annotations.ReactModule;

import javax.annotation.Nullable;

public class VectorDrawableManager extends SimpleViewManager<ImageView> {
    ReactApplicationContext mCallerContext;

    public VectorDrawableManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return VectorDrawableManagerImpl.NAME;
    }

    @Override
    protected ImageView createViewInstance(ThemedReactContext context) {
        return VectorDrawableManagerImpl.createViewInstance(context);
    }

    @ReactProp(name="resourceName")
    public void setResourceName(ImageView view, @Nullable String resourceName) {
        VectorDrawableManagerImpl.setResourceName(view, resourceName);
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(ImageView view, @Nullable String resizeMode) {
        VectorDrawableManagerImpl.setResizeMode(view, resizeMode);
    }

    @ReactProp(name = "tintColor", customType = "Color")
    public void setTintColor(ImageView view, @Nullable Integer tintColor) {
        VectorDrawableManagerImpl.setTintColor(view, tintColor);
    }
}
