@file:Suppress("MagicNumber")

package app.futured.academyproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val orange300 = Color(0xffff7361)
val orange100 = Color(0xfff9e0d9)

val blue400 = Color(0xff415aff)
val blue200 = Color(0xffAED5FE)

val pureWhite = Color(0xffffffff)

val cloud50 = Color(0xffF0F2F5)
val cloud100 = Color(0xffDBE0E5)
val cloud200 = Color(0xffC3CBD4)
val cloud300 = Color(0xffAAB6C3)

val ink900 = Color(0xff0D0F11)
val ink800 = Color(0xff17191C)
val ink700 = Color(0xff1C1F22)
val ink600 = Color(0xff222428)

object CustomColor {
    val textSecondary: Color
        @Composable
        get() = if (isSystemInDarkTheme()) cloud300 else ink600
}
