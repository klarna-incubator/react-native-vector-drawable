import {
  ViewProps,
  FlexStyle,
  TransformsStyle,
  ColorValue,
  HostComponent,
} from 'react-native';

// @ts-ignore
import {WithDefault} from 'react-native/Libraries/Types/CodegenTypes';
// @ts-ignore
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export type VectorDrawableResizeMode =
  | 'cover'
  | 'contain'
  | 'stretch'
  | 'center';

export interface VectorDrawableProps extends ViewProps {
  /**
   * The name of the vector drawable resource.
   */
  resourceName: string;
  resizeMode?: WithDefault<VectorDrawableResizeMode, 'contain'>;
  tintColor?: ColorValue;
}

export default codegenNativeComponent<VectorDrawableProps>(
  'RNVectorDrawable'
) as HostComponent<VectorDrawableProps>;
