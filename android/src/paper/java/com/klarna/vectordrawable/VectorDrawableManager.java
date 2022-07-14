package com.klarna.vectordrawable;

import android.widget.ImageView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
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
