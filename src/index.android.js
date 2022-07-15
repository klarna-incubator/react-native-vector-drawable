import { requireNativeComponent } from 'react-native';

const isFabricEnabled = global.nativeFabricUIManager != null;

const RNVectorDrawable = isFabricEnabled
  ? require('./RNVectorDrawableNativeComponent').default
  : requireNativeComponent('RNVectorDrawable');

export default RNVectorDrawable;
