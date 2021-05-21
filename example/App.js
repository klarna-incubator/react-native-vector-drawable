import React from 'react';
import { Image, ScrollView, StyleSheet, Text, View } from 'react-native';
import VectorDrawable from '@klarna/react-native-vector-drawable';

const Example = ({ title, resizeMode, tintColor, width = 35, height = 30 }) => {
  const style = {
    width,
    height,
    tintColor,
    resizeMode,
  };
  return (
    <View style={styles.row}>
      <Text style={styles.rowTitle}>{title}</Text>
      <Image source={require('./klarna-logo.png')} style={style} />
      <VectorDrawable resourceName="ic_klarna_logo" style={style} />
    </View>
  );
};

const App = () => {
  return (
    <ScrollView
      contentInsetAdjustmentBehavior="automatic"
      contentContainerStyle={styles.container}
    >
      <Text style={styles.heading}>resizeMode</Text>
      <Example title="default" width={60} height={40} />
      <Example title="contain" width={60} height={40} resizeMode="contain" />
      <Example title="cover" width={60} height={40} resizeMode="cover" />
      <Example title="stretch" width={60} height={40} resizeMode="stretch" />
      <Example title="center" width={60} height={40} resizeMode="center" />
      <Text style={styles.heading}>tintColor</Text>
      <Example title="pink" tintColor="#FFB3C7" />
      <Example title="translucent blue" tintColor="rgba(0, 0, 255, 0.5)" />
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
  },
  heading: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 20,
  },
  rowTitle: {
    width: '40%',
  },
});

export default App;
