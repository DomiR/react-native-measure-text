import { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";
import * as ReactNativeMeasureText from "react-native-measure-text";

export default function App() {
  const [widthResult, setWidthResult] = useState<number>(0);
  const toMeasure = "Hello world!";
  return (
    <View style={styles.container}>
      <Text>Result: {JSON.stringify(widthResult)}</Text>
      <View
        style={{ borderColor: "black", borderWidth: 1, width: widthResult + 1 }}
      >
        <Text style={{ fontSize: 20 }} numberOfLines={1} ellipsizeMode="clip">
          {toMeasure}
        </Text>
      </View>
      <Button
        onPress={() => {
          setWidthResult(
            Math.ceil(
              ReactNativeMeasureText.measureWidth(toMeasure, {
                // fontSize: 20,
                // fontFamily: 'Helvetica',
                // fontWeight: 'normal',
                // maxHeight: 100,
              })
            )
          );
        }}
        title="Calc width"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "red",
    alignItems: "center",
    justifyContent: "center",
  },
});
