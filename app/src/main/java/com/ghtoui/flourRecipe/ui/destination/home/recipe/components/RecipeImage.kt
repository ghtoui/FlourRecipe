package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.FlourAsyncImage
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * レシピの完成画像
 *
 * @param imagePath 画像のパス
 * @param recipeName レシピの名前
 * @param modifier [Modifier]
 */
@Composable
internal fun RecipeImage(
    imagePath: String,
    recipeName: String,
    modifier: Modifier = Modifier,
) {
    FlourAsyncImage(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .aspectRatio(16f / 9f),
        path = imagePath,
        contentDescription = stringResource(
            id = R.string.description_recipe_image,
            recipeName,
        ),
    )
}

@Preview
@Composable
private fun RecipeImagePreview() {
    FlourRecipeTheme {
        Surface {
            RecipeImage(
                modifier = Modifier.size(100.dp),
                imagePath = "https://example.com",
                recipeName = "パン",
            )
        }
    }
}
