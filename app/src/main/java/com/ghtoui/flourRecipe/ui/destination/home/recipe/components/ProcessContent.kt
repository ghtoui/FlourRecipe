package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.ui.components.NumberText
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyProcess
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun ProcessContent(
    recipeProcess: List<RecipeProcess>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        recipeProcess.forEachIndexed { index, recipeProcess ->
            NumberText(number = index)
        }
    }
}

@Preview
@Composable
private fun ProcessContentPreview() {
    val dummyRecipeProcess = getDummyProcess()
    FlourRecipeTheme {
        Surface {
            ProcessContent(
                modifier = Modifier,
                recipeProcess = dummyRecipeProcess,
            )
        }
    }
}
