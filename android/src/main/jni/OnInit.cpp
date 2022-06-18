#include <fbjni/fbjni.h>

#include "VectorDrawableComponentsRegistry.h"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *) {
  return facebook::jni::initialize(vm, [] {
    facebook::react::VectorDrawableComponentsRegistry::registerNatives();
  });
}