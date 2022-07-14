package com.klarna.vectordrawable;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNVectorDrawableManagerDelegate;
import com.facebook.react.viewmanagers.RNVectorDrawableManagerInterface;

@ReactModule(name = VectorDrawableManagerImpl.NAME)
public class VectorDrawableManager extends SimpleViewManager<ImageView>
        implements RNVectorDrawableManagerInterface<ImageView> {
    private final ViewManagerDelegate<ImageView> mDelegate;

    public VectorDrawableManager(ReactApplicationContext context) {
        mDelegate = new RNVectorDrawableManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<ImageView> getDelegate() {
        return mDelegate;
    }

    @Nullable
    @Override
    public String getName() {
        return VectorDrawableManagerImpl.NAME;
    }

    @NonNull
    @Override
    protected ImageView createViewInstance(@NonNull ThemedReactContext context) {
        return VectorDrawableManagerImpl.createViewInstance(context);
    }

    @Override
    @ReactProp(name = "resourceName")
    public void setResourceName(ImageView view, @Nullable String resourceName) {
        VectorDrawableManagerImpl.setResourceName(view, resourceName);
    }

    @Override
    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(ImageView view, @Nullable String resizeMode) {
        VectorDrawableManagerImpl.setResizeMode(view, resizeMode);
    }

    @Override
    @ReactProp(name = "tintColor", customType = "Color")
    public void setTintColor(ImageView view, @Nullable Integer tintColor) {
        VectorDrawableManagerImpl.setTintColor(view, tintColor);
    }
}
