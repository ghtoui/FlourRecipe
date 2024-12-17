package com.ghtoui.flourRecipe.ui.components.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 追加ボタン
 *
 * @param onClick クリックした時
 * @param modifier [Modifier]
 */
@Composable
internal fun AddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(
            text = stringResource(R.string.add_label),
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Preview
@Composable
private fun AddButtonPreview() {
    FlourRecipeTheme {
        Surface {
            AddButton(
                onClick = {},
            )
        }
    }
}
