import React from 'react';
import { ScrollView, StyleSheet } from 'react-native';
import VectorDrawable from '@klarna/react-native-vector-drawable';

const App = () => {
  return (
    <ScrollView
      contentInsetAdjustmentBehavior="automatic"
      contentContainerStyle={styles.container}
    >
      <VectorDrawable resourceName="ic_klarna_logo" style={styles.logo} />
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
  },
  logo: {
    width: 35,
    height: 30,
    tintColor: '#FFB3C7',
  },
});

export default App;
