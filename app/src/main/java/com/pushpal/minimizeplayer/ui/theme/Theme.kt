package com.pushpal.minimizeplayer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColorPalette = MinPlayerColorPalette(
  brand = White,
  accent = MinPlayerColor,
  uiBackground = Neutral0,
  uiBorder = VeryLightGrey,
  uiFloated = FunctionalRed,
  textPrimary = TextPrimary,
  textSecondary = TextSecondary,
  textSecondaryDark = TextSecondaryDark,
  error = FunctionalRed,
  isDark = false,
  buttonTextColor = White
)

private val DarkColorPalette = MinPlayerColorPalette(
  brand = Shadow1,
  accent = Ocean2,
  uiBackground = GreyBg,
  uiBorder = GreyBgDark,
  uiFloated = Ocean2,
  textPrimary = Shadow1,
  textSecondary = Neutral0,
  textSecondaryDark = Neutral0,
  error = FunctionalRedDark,
  isDark = true,
  buttonTextColor = Ocean2
)

@Composable
fun MinPlayerTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) DarkColorPalette else LightColorPalette

  val sysUiController = LocalSysUiController.current
  SideEffect {
    sysUiController.setSystemBarsColor(
      color = colors.uiBackground.copy(alpha = AlphaNearOpaque)
    )
  }

  ProvideMinPlayerColors(colors) {
    MaterialTheme(
      colors = debugColors(darkTheme),
      typography = MinPlayerTypography,
      shapes = MinPlayerShapes,
      content = content
    )
  }
}

object MinPlayerTheme {
  val colors: MinPlayerColorPalette
    @Composable
    get() = LocalMinPlayerColor.current
}

/**
 * MinPlayer custom Color Palette
 */
@Stable
class MinPlayerColorPalette(
  brand: Color,
  accent: Color,
  uiBackground: Color,
  uiBorder: Color,
  uiFloated: Color,
  textPrimary: Color = brand,
  textSecondaryDark: Color,
  textSecondary: Color,
  error: Color,
  isDark: Boolean,
  buttonTextColor: Color
) {
  var accent by mutableStateOf(accent)
    private set
  var uiBackground by mutableStateOf(uiBackground)
    private set
  var uiBorder by mutableStateOf(uiBorder)
    private set
  var uiFloated by mutableStateOf(uiFloated)
    private set
  var textPrimary by mutableStateOf(textPrimary)
    private set
  var textSecondary by mutableStateOf(textSecondary)
    private set
  var textSecondaryDark by mutableStateOf(textSecondaryDark)
    private set
  var error by mutableStateOf(error)
    private set
  var isDark by mutableStateOf(isDark)
    private set

  var buttonTextColor by mutableStateOf(buttonTextColor)
    private set

  fun update(other: MinPlayerColorPalette) {
    uiBackground = other.uiBackground
    uiBorder = other.uiBorder
    uiFloated = other.uiFloated
    textPrimary = other.textPrimary
    textSecondary = other.textSecondary
    error = other.error
    isDark = other.isDark
    buttonTextColor = other.buttonTextColor
  }
}

@Composable
fun ProvideMinPlayerColors(
  colors: MinPlayerColorPalette,
  content: @Composable () -> Unit
) {
  val colorPalette = remember { colors }
  colorPalette.update(colors)
  CompositionLocalProvider(LocalMinPlayerColor provides colorPalette, content = content)
}

private val LocalMinPlayerColor = staticCompositionLocalOf<MinPlayerColorPalette> {
  error("No MinPlayerColorPalette provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [MinPlayerTheme.colors].
 */
fun debugColors(
  darkTheme: Boolean,
  debugColor: Color = Color.Red
) = Colors(
  primary = debugColor,
  primaryVariant = debugColor,
  secondary = debugColor,
  secondaryVariant = debugColor,
  background = debugColor,
  surface = debugColor,
  error = debugColor,
  onPrimary = debugColor,
  onSecondary = debugColor,
  onBackground = debugColor,
  onSurface = debugColor,
  onError = debugColor,
  isLight = !darkTheme
)