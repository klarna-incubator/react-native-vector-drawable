#include "VectorDrawableComponentsRegistry.h"

#include <CoreComponentsRegistry.h>
#include <fbjni/fbjni.h>
#include <react/renderer/componentregistry/ComponentDescriptorProviderRegistry.h>
#include <react/renderer/components/vectordrawable/ComponentDescriptors.h>
#include <react/renderer/mapbuffer/MapBuffer.h>
#include <react/renderer/mapbuffer/MapBufferBuilder.h>

namespace facebook {
namespace react {

VectorDrawableComponentsRegistry::VectorDrawableComponentsRegistry(
    ComponentFactory *delegate)
    : delegate_(delegate) {}

std::shared_ptr<ComponentDescriptorProviderRegistry const>
VectorDrawableComponentsRegistry::sharedProviderRegistry() {
  auto providerRegistry = CoreComponentsRegistry::sharedProviderRegistry();
  providerRegistry->add(concreteComponentDescriptorProvider<RNVectorDrawableComponentDescriptor>());
  return providerRegistry;
}

jni::local_ref<VectorDrawableComponentsRegistry::jhybriddata>
VectorDrawableComponentsRegistry::initHybrid(
    jni::alias_ref<jclass>,
    ComponentFactory *delegate) {
  auto instance = makeCxxInstance(delegate);

  auto buildRegistryFunction =
      [](EventDispatcher::Weak const &eventDispatcher,
         ContextContainer::Shared const &contextContainer)
      -> ComponentDescriptorRegistry::Shared {
    auto registry = VectorDrawableComponentsRegistry::sharedProviderRegistry()
                        ->createComponentDescriptorRegistry(
                            {eventDispatcher, contextContainer});

    return registry;
  };

  delegate->buildRegistryFunction = buildRegistryFunction;
  return instance;
}

void VectorDrawableComponentsRegistry::registerNatives() {
  registerHybrid({
      makeNativeMethod("initHybrid", VectorDrawableComponentsRegistry::initHybrid),
  });
  // See: https://github.com/software-mansion/react-native-screens/blob/main/android/src/main/jni/RNScreensComponentsRegistry.cpp#L62
  sharedProviderRegistry();
}

} // namespace react
} // namespace facebook