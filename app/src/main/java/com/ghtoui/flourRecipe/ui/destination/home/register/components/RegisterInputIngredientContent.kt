package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.IngredientCategory
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 材料登録コンテンツ
 *
 * @param ingredients 材料リスト
 * @param onIngredientAddClick 追加をクリック
 * @param modifier [Modifier]
 */
@Composable
internal fun RegisterInputIngredientContent(
    ingredients: List<RecipeIngredient>,
    onIngredientAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val otherIngredients = ingredients.filter {
        it.baseIngredient.ingredientCategory != IngredientCategory.Flour
    }

    Column(
        modifier = modifier,
    ) {
        RegisterInputTitle(
            title = stringResource(R.string.register_recipe_input_ingredient_title)
        )
        Spacer(modifier = Modifier.height(12.dp))
        RegisterInputContent(
            ingredients = otherIngredients,
            totalQuantity = null,
            onAddClick = onIngredientAddClick
        )
    }
}

@Preview
@Composable
private fun RegisterInputIngredientContentPreview() {
    val dummyIngredients = getDummyIngredients()
    FlourRecipeTheme {
        Surface {
            RegisterInputIngredientContent(
                modifier = Modifier,
                onIngredientAddClick = {},
                ingredients = dummyIngredients
            )
        }
    }
}
