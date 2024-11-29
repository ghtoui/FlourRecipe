package com.ghtoui.flourRecipe.ui.destination.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.ui.component.FlourAsyncImage
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * ホームのリストアイテム
 */
@Composable
fun HomeListItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        FlourAsyncImage(
            path = "",
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun HomeListItemPreview() {
    FlourRecipeTheme {
        Surface {
            HomeListItem()
        }
    }
}
