package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.ui.components.NumberText
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyProcess
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 手順のアイテム
 *
 * @param index 何番目か
 * @param recipeProcess 手順
 * @param modifier [Modifier]
 */
@Composable
internal fun ProcessItem(
    index: Int,
    recipeProcess: RecipeProcess,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        NumberText(number = index)
        Spacer(modifier = Modifier.width(16.dp))
        ProcessDescription(
            modifier = Modifier.padding(top = 2.dp),
            recipeProcess = recipeProcess,
        )
    }
}

@Composable
private fun ProcessDescription(
    recipeProcess: RecipeProcess,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = recipeProcess.name,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = recipeProcess.description,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
private fun ProcessItemPreview() {
    val dummyRecipeProcess = getDummyProcess().first()
    FlourRecipeTheme {
        Surface {
            ProcessItem(
                modifier = Modifier,
                index = 1,
                recipeProcess = dummyRecipeProcess,
            )
        }
    }
}
