package com.animal_villa.ui.theme

private val colorPalette = Pinks(
    primary = pink
)

fun AnimalVillaTheme(content: @Composable () -> Unit){
    val colors = colorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}