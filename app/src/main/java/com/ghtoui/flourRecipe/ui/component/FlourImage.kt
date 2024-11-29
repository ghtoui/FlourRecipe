package com.ghtoui.flourRecipe.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * このアプリで使用するAsyncImage
 */
@Composable
fun FlourAsyncImage(
    path: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    placeholder: Painter = BrushPainter(
        brush = Brush.linearGradient(
            listOf(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.surface,
            )
        )
    ),
) {
    AsyncImage(
        modifier = modifier,
        model = path,
        contentDescription = contentDescription,
        contentScale = contentScale,
        placeholder = placeholder,
        error = painterResource(id = R.drawable.ic_bread)
    )
}

@Preview
@Composable
private fun FlourImagePreview() {
    FlourRecipeTheme {
        Surface {
            FlourAsyncImage(
                modifier = Modifier.size(100.dp),
                path = "https://example.com",
                contentDescription = null,
            )
        }
    }
}
