package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * 二つの色の横線
 *
 * @param modifier [Modifier]
 */
@Composable
internal fun BiColorHorizontalDivider(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.primary,
        )
        HorizontalDivider(modifier = Modifier.weight(2f))
    }
}
