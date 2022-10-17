import ReactNativeMeasureText from "./ReactNativeMeasureTextModule";

export function measureWidth(
  text: string,
  style: { fontSize?: number; fontFamily?: string; fontWeight?: string } = {}
): number {
  return ReactNativeMeasureText.measureWidth(text, style);
}
