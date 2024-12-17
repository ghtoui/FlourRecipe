package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.ReferenceItem
import com.ghtoui.flourRecipe.ui.components.button.AddButton
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import java.net.URL

/**
 * 参照したもののコンテンツ
 *
 * @param references 参照したもののリスト
 * @param onReferenceAddClick 参照するものを追加するをクリック
 * @param onReferenceURLClick webサイトのアイテムをクリック
 * @param modifier [Modifier]
 */
@Composable
internal fun RegisterInputReferenceContent(
    references: List<String>,
    onReferenceAddClick: () -> Unit,
    onReferenceURLClick: (URL) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        RegisterInputTitle(
            title = stringResource(R.string.register_recipe_input_reference_title)
        )
        Spacer(modifier = Modifier.height(12.dp))
        RegisterInputReference(
            modifier = Modifier.fillMaxWidth(),
            onReferenceAddClick = onReferenceAddClick,
            references = references,
            onReferenceURLClick = onReferenceURLClick,
        )
    }
}

@Composable
private fun RegisterInputReference(
    references: List<String>,
    onReferenceAddClick: () -> Unit,
    onReferenceURLClick: (URL) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column {
            references.forEach { reference ->
                ReferenceItem(
                    reference = reference,
                    onReferenceURLClick = onReferenceURLClick
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        AddButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = onReferenceAddClick
        )
    }
}

@Preview
@Composable
private fun RegisterInputReferenceContentPreview() {
    val dummyReferences = listOf(
        "https://example.com",
        "本",
        "https://example.com",
        "レシピ本",
    )
    FlourRecipeTheme {
        Surface {
            RegisterInputReferenceContent(
                references = dummyReferences,
                onReferenceAddClick = {},
                onReferenceURLClick = {},
            )
        }
    }
}
