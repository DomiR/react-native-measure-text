# react-native-measure-text

Measure the size of a string of text in React Native synchronously.

This can be useful for calculating the size of a string of text before rendering it, for example for animation targets.

# API documentation

### Add the package to your npm dependencies

```
npm install @domir/react-native-measure-text
```

### Configure for iOS

Run `npx pod-install` after installing the npm package.


### Configure for Android

No additional configuration is needed.

### Usage

```js
import * as MeasureText from '@domir/react-native-measure-text';

MeasureText.measureWidth('Hello World', {
  fontSize: 20,
  fontFamily: 'Helvetica',
  fontWeight: 'normal',
  // TBD
  // fontStyle: 'normal',
  // fontVariant: ['small-caps'],
  // letterSpacing: 0,
  // lineHeight: 20,
  // textAlign: 'left',
  // textDecorationLine: 'none',
  // textTransform: 'none',
  // includeFontPadding: true,
  // maxWidth: 100,
  // maxHeight: 100,
  // numberOfLines: 1,
  // ellipsizeMode: 'tail',
})