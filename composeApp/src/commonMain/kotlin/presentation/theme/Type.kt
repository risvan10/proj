package presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val inter = FontFamily.Default
val Typography = Typography(
    h1 = TextStyle( //headlineLarge
        fontFamily = inter,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp
    ),
    h3 = TextStyle(//headlineSmall
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),
    h2 = TextStyle( //headlineMedium
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    h4 = TextStyle(//bodyLarge
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    body1 = TextStyle( //bodyMedium
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),
    body2 = TextStyle( //bodySmall
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 9.sp,
    ),
    h5 = TextStyle( //titleLarge
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 23.sp,
    ),
    h6 = TextStyle( //titleMedium
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
    ),
    caption = TextStyle( //titleSmall
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
    )
)