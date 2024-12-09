package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.BiColorHorizontalDivider
import com.ghtoui.flourRecipe.ui.components.ReferenceItem
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import java.net.URL

/**
 * 参照したもののコンテンツ
 *
 * @param references 参照リスト
 * @param onReferenceURLClick URLのクリック
 * @param modifier [Modifier]
 */
@Composable
internal fun ReferenceContent(
    references: List<String>,
    onReferenceURLClick: (URL) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.recipe_reference),
            style = MaterialTheme.typography.titleLarge,
        )
        BiColorHorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            references.forEach { reference ->
                ReferenceItem(
                    reference = reference,
                    onReferenceURLClick = onReferenceURLClick,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ReferenceContentPreview() {
    FlourRecipeTheme {
        Surface {
            ReferenceContent(
                modifier = Modifier,
                references = listOf(
                    "https://example.com",
                    "パン作りの本 2ページ目",
                    "パン作りの本 2ページ目",
                    "パン作りの本 2ページ目",
                ),
                onReferenceURLClick = {},
            )
        }
    }
}
