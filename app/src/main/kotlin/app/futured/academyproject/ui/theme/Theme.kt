package app.futured.academyproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColorScheme(
    primary = orange300,
    onPrimary = pureWhite,
    secondary = blue400,
    onSecondary = pureWhite,
    background = pureWhite,
    onBackground = ink900,
    surface = pureWhite,
    onSurface = ink900,
)

private val DarkColorPalette = darkColorScheme(
    primary = orange300,
    onPrimary = pureWhite,
    secondary = blue400,
    onSecondary = pureWhite,
    background = ink900,
    onBackground = pureWhite,
    surface = ink900,
    onSurface = pureWhite,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content,
    )
}
