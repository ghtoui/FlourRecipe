package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.ui.components.NumberText
import com.ghtoui.flourRecipe.ui.components.TitleBorderBox
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
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row {
            NumberText(number = index)
            Spacer(modifier = Modifier.width(16.dp))
            ProcessDescription(
                modifier = Modifier.padding(top = 6.dp),
                recipeProcess = recipeProcess
            )
        }
        recipeProcess.memo?.let {
            Spacer(modifier = Modifier.height(12.dp))
            ProcessMemo(
                modifier = Modifier.fillMaxWidth(),
                memo = it
            )
        }

    }
}

@Composable
private fun ProcessDescription(
    recipeProcess: RecipeProcess,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = recipeProcess.name,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = recipeProcess.description,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
private fun ProcessMemo(
    memo: String,
    modifier: Modifier = Modifier
) {
    TitleBorderBox(
        modifier = modifier,
        topTitle = stringResource(id = R.string.recipe_memo)
    ) {
        Text(
            text = memo,
            style = MaterialTheme.typography.bodyMedium
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
