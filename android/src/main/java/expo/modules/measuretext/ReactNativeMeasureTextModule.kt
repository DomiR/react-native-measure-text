package expo.modules.measuretext

import android.graphics.Typeface
import android.text.TextPaint
import com.facebook.react.uimanager.PixelUtil
import com.facebook.react.views.text.ReactFontManager
import com.facebook.react.views.text.ReactTypefaceUtils.parseFontWeight
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record

class StyleOptions : Record {
  @Field
  val letterSpacing: Float? = null

  @Field
  val fontFamily: String? = null

  @Field
  val fontWeight: String? = null

  @Field
  val fontSize: Int? = null

  @Field
  val allowFontScaling: Boolean? = null
}

class ReactNativeMeasureTextModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("ReactNativeMeasureText")

    Function("measureWidth") { text: String, style: StyleOptions ->
      val paint = createTextPaint(style.fontSize, style.fontFamily, style.fontWeight, style.letterSpacing, style.allowFontScaling);
      return@Function paint.measureText(text);
    }
  }

  private fun createTextPaint(fontSize: Int?, fontFamily: String?, fontWeight: String?, letterSpacing: Float?, allowFontScaling: Boolean?): TextPaint {
    val paint = TextPaint(TextPaint.ANTI_ALIAS_FLAG);
    val fontScale = appContext.reactContext?.resources?.configuration?.fontScale ?: 1.0f;
    val allowScaledFont = allowFontScaling ?: true;
    val usedFontSize = (fontSize ?: 0) * fontScale;
    paint.textSize = usedFontSize;
    val letterSpacingPixels = if (allowScaledFont)  PixelUtil.toPixelFromSP(letterSpacing ?: 0f) else PixelUtil.toPixelFromDIP(letterSpacing ?: 0f);
    val mFontSize = if (allowScaledFont) Math.ceil(PixelUtil.toPixelFromSP(usedFontSize).toDouble()).toInt() else Math.ceil(PixelUtil.toPixelFromDIP(usedFontSize).toDouble()).toInt();
    val usedLetterSpacing = if (letterSpacingPixels <= 0f) letterSpacing ?: 0f else letterSpacingPixels / mFontSize;
    paint.letterSpacing = usedLetterSpacing;
    val assetManager = appContext.reactContext?.assets;

    if (fontFamily == null || assetManager == null || fontWeight == null) {
      paint.typeface = Typeface.DEFAULT
    } else {
      paint.typeface = ReactFontManager.getInstance().getTypeface(fontFamily, parseFontWeight(fontWeight), assetManager)
    }

    return paint;
  }
}
