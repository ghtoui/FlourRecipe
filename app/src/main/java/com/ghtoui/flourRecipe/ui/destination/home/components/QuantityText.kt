package com.ghtoui.flourRecipe.ui.destination.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun QuantityText(
    quantity: Int,
    unit: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.alignByBaseline(),
            text = "$quantity",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.alignByBaseline(),
            text = unit,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Composable
private fun QuantityTextPreview(
    @PreviewParameter(QuantityTextPreviewPPP::class) param: QuantityTextPreviewPPP.Param
) {
    FlourRecipeTheme {
        Surface {
            QuantityText(
                quantity = 100,
                unit = param.unit,
            )
        }
    }
}

private class QuantityTextPreviewPPP : CollectionPreviewParameterProvider<QuantityTextPreviewPPP.Param>(
    listOf(
        Param(
            unit = "g"
        ),
        Param(
            unit = "cm"
        ),
        Param(
            unit = "個"
        ),
    )
) {
    data class Param(
        val unit: String
    )
}
