package com.sovaran.pricingjetpack.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sovaran.pricingjetpack.R
import com.sovaran.pricingjetpack.activity.ui.theme.Purple700


private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = White,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = White,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

val fonts = FontFamily(
    Font(R.font.poppinsregular, FontWeight.Normal),
    Font(R.font.poppinsbold, weight = FontWeight.Bold),
    Font(R.font.poppinsextrabold, weight = FontWeight.ExtraBold),
    Font(R.font.poppinssemibold, weight = FontWeight.SemiBold),
    Font(R.font.poppinsmedium, weight = FontWeight.Medium)
)

val appTypography = Typography(
    body1 = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Normal),
    h1 = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Bold),
    body2 = TextStyle(fontFamily = fonts, fontWeight = FontWeight.ExtraBold),
    h2 = TextStyle(fontFamily = fonts, fontWeight = FontWeight.SemiBold),
    h3 = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Medium)
)


@Composable
fun PricingJetpackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()

    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Black
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = White
        )
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = appTypography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun HomeScreenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Purple700
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Purple700
        )
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = appTypography,
        shapes = Shapes,
        content = content
    )
}