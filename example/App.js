import React from 'react';
import { ScrollView, StyleSheet, View } from 'react-native';
import VectorDrawable from '@klarna/react-native-vector-drawable';

const Logo = (props) => (
  <View style={{ borderWidth: 1, margin: 10 }}>
    <VectorDrawable
      resourceName="ic_klarna_logo"
      style={{
        width: 100,
        height: 50,
        tintColor: '#FFB3C7',
      }}
      {...props}
    />
  </View>
);

const App = () => {
  return (
    <ScrollView
      contentInsetAdjustmentBehavior="automatic"
      contentContainerStyle={styles.container}
    >
      <Logo resizeMode="contain" />
      <Logo resizeMode="cover" />
      <Logo resizeMode="stretch" />
      <Logo resizeMode="center" />
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default App;
