package org.onedroid.protobufbuilder.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.onedroid.protobufbuilder.R

val JetBrainsFontFamily = FontFamily(
    Font(R.font.jet_brains_mono_regular, FontWeight.Normal),
    Font(R.font.jet_brains_mono_bold, FontWeight.Bold),
    Font(R.font.jet_brains_mono_medium, FontWeight.Medium),
    Font(R.font.jet_brains_mono_semi_bold, FontWeight.SemiBold),
    Font(R.font.jet_brains_mono_extra_bold, FontWeight.ExtraBold),
    Font(R.font.jet_brains_mono_light, FontWeight.Light),
    Font(R.font.jet_brains_mono_thin, FontWeight.ExtraLight),
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = JetBrainsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = JetBrainsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = JetBrainsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = JetBrainsFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)