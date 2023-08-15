import ReactNativeMeasureText from "./ReactNativeMeasureTextModule";

export function measureWidth(
  text: string,
  style: { fontSize?: number; fontFamily?: string; fontWeight?: string, letterSpacing?: number, allowFontScaling?: boolean } = {}
): number {
  return ReactNativeMeasureText.measureWidth(text, style);
}
