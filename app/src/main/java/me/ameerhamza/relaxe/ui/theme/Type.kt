package me.ameerhamza.relaxe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.ameerhamza.relaxe.R

// Set of Material typography styles to start with

val redeaxpro = FontFamily(
    listOf(
        Font(R.font.readex_pro_light, FontWeight.Light),
        Font(R.font.readex_pro_regular, FontWeight.Normal),
        Font(R.font.readex_pro_medium, FontWeight.Medium),
        Font(R.font.readex_pro_bold, FontWeight.Bold),
    )
)

val Typography = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontFamily = redeaxpro,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    h1 = TextStyle(
        color = TextWhite,
        fontFamily = redeaxpro,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    h2 = TextStyle(
        color = TextWhite,
        fontFamily = redeaxpro,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    h3 = TextStyle(
        color = TextWhite,
        fontFamily = redeaxpro,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
)
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)