package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.BiColorHorizontalDivider
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyProcess
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * レシピの手順コンテンツ
 *
 * @param recipeProcess 手順
 * @param modifier [Modifier]
 */
@Composable
internal fun ProcessContent(
    recipeProcess: List<RecipeProcess>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        RecipeTitle()
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            recipeProcess.forEachIndexed { index, recipeProcess ->
                // 1始まりにする
                ProcessItem(
                    index = index + 1,
                    recipeProcess = recipeProcess,
                )
                HorizontalDivider()
            }
        }
    }
}

@Composable
private fun RecipeTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.recipe_process),
            style = MaterialTheme.typography.headlineLarge,
        )
        BiColorHorizontalDivider(modifier = Modifier.fillMaxWidth())
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
