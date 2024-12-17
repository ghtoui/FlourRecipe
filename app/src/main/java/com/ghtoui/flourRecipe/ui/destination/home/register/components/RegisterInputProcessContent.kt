package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.RecipeProcess
import com.ghtoui.flourRecipe.ui.components.button.AddButton
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyProcess
import com.ghtoui.flourRecipe.ui.destination.home.recipe.components.ProcessItem
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 手順登録コンテンツ
 *
 * @param process 手順
 * @param onAddInputProcessClick 手順追加ボタンクリック
 * @param modifier [Modifier]
 */
@Composable
internal fun RegisterInputProcessContent(
    process: List<RecipeProcess>,
    onAddInputProcessClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        process.forEachIndexed { index, process ->
            ProcessItem(
                recipeProcess = process,
                // 1始まりにする
                index = index + 1,
            )
            HorizontalDivider()
        }
        AddButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onAddInputProcessClick
        )
    }
}

@Preview
@Composable
private fun RegisterInputProcessContentPreview() {
    val dummyProcess = getDummyProcess()
    FlourRecipeTheme {
        Surface {
            RegisterInputProcessContent(
                process = dummyProcess,
                modifier = Modifier,
                onAddInputProcessClick = {},
            )
        }
    }
}
