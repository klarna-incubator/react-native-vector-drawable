#pragma once

#include <ComponentFactory.h>
#include <fbjni/fbjni.h>
#include <react/renderer/componentregistry/ComponentDescriptorProviderRegistry.h>
#include <react/renderer/componentregistry/ComponentDescriptorRegistry.h>

namespace facebook {
namespace react {

class VectorDrawableComponentsRegistry
    : public facebook::jni::HybridClass<VectorDrawableComponentsRegistry> {
 public:
  constexpr static auto kJavaDescriptor =
      "Lcom/klarna/vectordrawable/VectorDrawableComponentsRegistry;";

  static void registerNatives();

  VectorDrawableComponentsRegistry(ComponentFactory *delegate);

 private:
  friend HybridBase;

  static std::shared_ptr<ComponentDescriptorProviderRegistry const> sharedProviderRegistry();

  const ComponentFactory *delegate_;

  static jni::local_ref<jhybriddata> initHybrid(
      jni::alias_ref<jclass>,
      ComponentFactory *delegate);
};

} // namespace react
} // namespace facebook