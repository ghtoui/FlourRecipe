package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.ui.components.button.AddButton
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 登録するコンテンツ
 *
 * @param totalQuantity 合計量
 * @param ingredients 材料リスト
 * @param onAddClick 追加をクリックしたとき
 * @param modifier [Modifier]
 */
@Composable
internal fun RegisterInputContent(
    totalQuantity: Int?,
    ingredients: List<RecipeIngredient>,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column {
            ingredients.forEach { ingredient ->
                InputFlourIngredientItem(
                    ingredient = ingredient,
                    totalQuantity = totalQuantity,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        AddButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = onAddClick
        )
    }
}

@Preview
@Composable
private fun RegisterInputContentPreview() {
    val dummyIngredients = getDummyIngredients()
    FlourRecipeTheme {
        Surface {
            RegisterInputContent(
                ingredients = dummyIngredients,
                onAddClick = {},
                modifier = Modifier,
                totalQuantity = 1000,
            )
        }
    }
}
