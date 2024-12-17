package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.ui.components.BiColorHorizontalDivider
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 登録するもののタイトル
 *
 * @param title タイトル
 * @param modifier [Modifier]
 */
@Composable
internal fun RegisterInputTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(4.dp))
        BiColorHorizontalDivider()
    }
}

@Preview
@Composable
private fun RegisterInputFlourTitlePreview() {
    FlourRecipeTheme {
        Surface {
            RegisterInputTitle(
                modifier = Modifier,
                title = "タイトル",
            )
        }
    }
}
