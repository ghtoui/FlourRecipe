package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun ProcessContent(
    recipeProcess: List<RecipeProcess>,
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
private fun ProcessContentPreview() {
    FlourRecipeTheme {
        Surface {
            ProcessContent(
                modifier = Modifier,
            )
        }
    }
}
