package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.TitleBorderBox
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 作り方のメモ
 *
 * @param memo メモ
 * @param modifier [Modifier]
 */
@Composable
internal fun ProcessMemo(
    memo: String,
    modifier: Modifier = Modifier,
) {
    TitleBorderBox(
        modifier = modifier,
        topTitle = stringResource(id = R.string.recipe_memo),
    ) {
        Text(
            text = memo,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
private fun ProcessMemoPreview() {
    FlourRecipeTheme {
        Surface {
            ProcessMemo(
                memo = "メモです．",
            )
        }
    }
}
