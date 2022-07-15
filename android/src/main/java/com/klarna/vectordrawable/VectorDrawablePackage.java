package com.klarna.vectordrawable;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class VectorDrawablePackage implements ReactPackage {
    @Override
    @NonNull
    public List<NativeModule> createNativeModules(@NonNull final ReactApplicationContext reactContext) {
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // TODO: Remove when auto-linking will support Fabric modules
            // See: https://github.com/software-mansion/react-native-screens/blob/main/android/src/main/java/com/swmansion/rnscreens/RNScreensPackage.kt#L16
            SoLoader.loadLibrary("vectordrawable_modules");
        }
        return Collections.emptyList();
    }

    @Override
    @NonNull
    public List<ViewManager> createViewManagers(@NonNull final ReactApplicationContext reactContext) {
        return Collections.singletonList(new VectorDrawableManager(reactContext));
    }
}
