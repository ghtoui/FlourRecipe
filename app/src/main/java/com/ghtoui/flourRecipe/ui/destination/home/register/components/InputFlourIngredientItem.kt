package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import kotlin.math.round

/**
 * 登録する材料のアイテム
 *
 * @param ingredient 材料
 * @param totalQuantity 合計量
 * @param modifier [Modifier]
 */
@Composable
internal fun InputFlourIngredientItem(
    ingredient: RecipeIngredient,
    totalQuantity: Int?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 4.dp
                )
        ) {
            Text(
                text = ingredient.baseIngredient.name,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(4.dp))
            AboutFlourQuantity(
                totalQuantity = totalQuantity,
                quantity = ingredient.quantity,
            )
        }
        HorizontalDivider()
    }
}

@Composable
private fun AboutFlourQuantity(
    totalQuantity: Int?,
    quantity: Int,
    modifier: Modifier = Modifier,
) {
    val flourRatio = if (totalQuantity != null) {
        round(quantity.toFloat() / totalQuantity.toFloat() * 1000) / 10
    } else {
        null
    }

    Row(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(
                R.string.gram_unit,
                quantity,
            ),
            style = MaterialTheme.typography.labelLarge
        )
        flourRatio?.let { flourRatio ->
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = stringResource(
                    R.string.format_parentheses,
                    stringResource(
                        R.string.ratio_unit,
                        flourRatio,
                    )
                ),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
private fun InputFlourIngredientItemPreview(
    @PreviewParameter(InputFlourIngredientItemPreviewPPP::class) param: InputFlourIngredientItemPreviewPPP.Param
) {
    val dummyIngredient = getDummyIngredients().first()
    FlourRecipeTheme {
        Surface {
            InputFlourIngredientItem(
                modifier = Modifier.padding(10.dp),
                totalQuantity = param.totalQuantity,
                ingredient = dummyIngredient,
            )
        }
    }
}

private class InputFlourIngredientItemPreviewPPP :
    CollectionPreviewParameterProvider<InputFlourIngredientItemPreviewPPP.Param>(
        listOf(
            Param(
                totalQuantity = 1000,
            ),
            Param(
                totalQuantity = null
            ),
        )
    ) {
    data class Param(
        val totalQuantity: Int?
    )
}
