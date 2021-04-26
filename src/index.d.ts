import * as React from 'react';
import { ViewProps } from 'react-native';

export interface VectorDrawableProps extends ViewProps {
  /**
   * The name of the vector drawable resource.
   */
  resourceName: string;
}

declare const VectorDrawable: React.FunctionComponent<VectorDrawableProps>;

export default VectorDrawable;
