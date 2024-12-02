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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
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
    val titleHeight = remember {
        mutableStateOf(0.dp)
    }
    val current = LocalDensity.current
    Box(
        modifier = Modifier,
    ) {
        Box(
            modifier = modifier
                .padding(top = titleHeight.value)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(24.dp),
                )
                .padding(horizontal = 12.dp, vertical = 20.dp),
        ) {
            content.invoke()
        }
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(24.dp),
                )
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(24.dp),
                )
                .padding(horizontal = 18.dp, vertical = 2.dp)
                .onGloballyPositioned {
                    with(current) {
                        titleHeight.value = (it.size.height / 2).toDp()
                    }
                }
        ) {
            Text(
                text = topTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
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
