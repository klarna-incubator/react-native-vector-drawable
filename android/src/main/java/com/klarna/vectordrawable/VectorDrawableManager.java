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

import com.facebook.react.common.JavascriptException;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.SimpleViewManager;

import javax.annotation.Nullable;

public class VectorDrawableManager extends SimpleViewManager<ImageView> {
    public static final String REACT_CLASS = "RNVectorDrawable";

    @Override
    public String getName() {
      return REACT_CLASS;
    }

    @Override
    protected ImageView createViewInstance(ThemedReactContext reactContext) {
      return new ImageView(reactContext);
    }

    @ReactProp(name="resourceName")
    public void setResourceName(ImageView view, @Nullable String resourceName) {
      Drawable draw = createVectorDrawable(view.getContext(), resourceName);
      view.setImageDrawable(draw);
    }

    @ReactProp(name = "tintColor", customType = "Color")
    public void setTintColor(ImageView view, @Nullable Integer tintColor) {
      if (tintColor == null) {
        view.clearColorFilter();
      } else {
        view.setColorFilter(tintColor, Mode.SRC_IN);
      }
    }

    private Drawable createVectorDrawable(Context context, String resourceName) throws JavascriptException{
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

        Drawable drawable = ContextCompat.getDrawable(context, resourceIdent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return (VectorDrawable) drawable;
        } else {
            return (BitmapDrawable) drawable;
        }
    }
}
