package com.klarna.vectordrawable;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class VectorDrawableComponentsRegistry {
  static {
    SoLoader.loadLibrary("vectordrawable_modules");
  }

  @DoNotStrip private final HybridData mHybridData;

  @DoNotStrip
  private native HybridData initHybrid(ComponentFactory componentFactory);

  @DoNotStrip
  private VectorDrawableComponentsRegistry(ComponentFactory componentFactory) {
    mHybridData = initHybrid(componentFactory);
  }

  @DoNotStrip
  public static VectorDrawableComponentsRegistry register(ComponentFactory componentFactory) {
    return new VectorDrawableComponentsRegistry(componentFactory);
  }
}