package app.UI.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = DarkGreen,
    primaryVariant = Purple700,
    secondary = Tan,
    background = Tan,
    surface = Tan


    //Other default colors to override
    //onPrimary = Color.White,
    //onSecondary = Color.Black,
    //onBackground = Color.Black,
    // onSurface = Color.Black,

)

@Composable
fun AnimalVillaTheme(content: @Composable () -> Unit){
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
   )
}