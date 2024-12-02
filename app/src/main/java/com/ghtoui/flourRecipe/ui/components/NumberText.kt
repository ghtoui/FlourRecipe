package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 番号のテキスト
 *
 * @param number 番号
 * @param modifier [Modifier]
 */
@Composable
internal fun NumberText(
    number: Int,
    modifier: Modifier = Modifier,
) {
    val textStyle = MaterialTheme.typography.bodyLarge
    val circleSize = rememberSaveable {
        mutableIntStateOf(textStyle.fontSize.value.toInt() * 2)
    }
    Box(
        modifier = modifier
            .size(circleSize.intValue.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier
                .onGloballyPositioned {
                    circleSize.intValue = maxOf(it.size.height, it.size.width) / 2
                }
                .padding(4.dp),
            text = "$number",
            style = textStyle,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}

@Preview
@Composable
private fun NumberTextPreview() {
    FlourRecipeTheme {
        Surface {
            Column {
                NumberText(number = 1)
                NumberText(number = 9)
                NumberText(number = 99)
                NumberText(number = 100)
            }
        }
    }
}
