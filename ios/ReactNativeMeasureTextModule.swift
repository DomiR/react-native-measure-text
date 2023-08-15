import ExpoModulesCore
import React

struct StyleOptions: Record {
  @Field
  var fontFamily: String? = nil

  @Field
  var fontWeight: String? = nil

  @Field
  var fontSize: Int? = nil

  @Field
  var letterSpacing: Double? = nil

  @Field
  var allowFontScaling: Bool? = nil // ANDROID ONLY
}

public class ReactNativeMeasureTextModule: Module {
  public func definition() -> ModuleDefinition {
    Name("ReactNativeMeasureText")

    Function("measureWidth") { (text: String, style: StyleOptions) -> CGFloat in
      let fontSize = style.fontSize != nil ? RCTConvert.cgFloat(style.fontSize) : CGFloat(0)
      let letterSpacing = style.letterSpacing != nil ? RCTConvert.cgFloat(style.letterSpacing) : CGFloat(0)
      let usedFontWeight = style.fontWeight ?? "Normal"

      if let font = style.fontFamily != nil ?
        RCTConvert.uiFont(["fontWeight": usedFontWeight, "fontFamily": style.fontFamily!, "fontSize": fontSize, NSAttributedString.Key.kern: letterSpacing ]) : RCTConvert.uiFont(["fontWeight": usedFontWeight, "fontSize": fontSize])
      {
        let size: CGSize = text.size(withAttributes: [.font: font])
        return size.width
      } else {
        return CGFloat(0)
      }
    }
  }
}
