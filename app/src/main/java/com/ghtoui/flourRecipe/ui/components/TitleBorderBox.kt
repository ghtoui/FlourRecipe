package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * タイトル付きのボーダー
 *
 * @param modifier [Modifier]
 */
@Composable
internal fun TitleBorderBox(
    topTitle: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val titleHeight = rememberSaveable {
        mutableIntStateOf(0)
    }
    Box(
        modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .padding(top = (titleHeight.intValue / 2).dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(horizontal = 12.dp, vertical = 30.dp)
        ) {
            content.invoke()
        }
        Text(
            modifier = Modifier
                .padding(start = 40.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(horizontal = 18.dp, vertical = 4.dp)
                .onGloballyPositioned {
                     titleHeight.intValue = it.size.height / 2
                },
            text = topTitle,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondary,
        )
    }

}

@Preview
@Composable
private fun TitleBorderBoxPreview() {
    FlourRecipeTheme {
        Surface {
            TitleBorderBox(
                topTitle = "メモ",
            ) {
                Text(text = "ここにはメモが入ります".repeat(3))
            }
        }
    }
}
