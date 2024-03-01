package presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun PurchaserTheme(
    content: @Composable () -> Unit
){

    val colors = lightColors(
        primary = Color(0xFF2E395F),
        secondary = Color(0xFFEDEDED),
        onSecondary = Color(0xFF0F0F0F),
        surface = Color(0xFFBDBDBD),
        background = Color(0xFFEDEDED),
        error = Color(0xFFC00000)
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}