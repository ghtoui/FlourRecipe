package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.domain.model.recipe.IngredientCategory
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.BiColorHorizontalDivider
import com.ghtoui.flourRecipe.ui.components.button.AddButton
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun RegisterInputFlourContent(
    ingredients: List<RecipeIngredient>,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val flourIngredients = ingredients.filter {
        it.baseIngredient.ingredientCategory == IngredientCategory.Flour
    }
    val flourTotalQuantity = flourIngredients.sumOf {
        it.quantity
    }
    Column(
        modifier = modifier
    ) {
        RegisterInputFlourTitle()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(
                R.string.register_recipe_input_total_quantity,
                flourTotalQuantity,
            ),
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column {
            flourIngredients.forEach { flourIngredient ->
                InputFlourIngredientItem(
                    ingredient = flourIngredient,
                    totalQuantity = flourTotalQuantity,
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

@Composable
private fun RegisterInputFlourTitle(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.register_recipe_input_flour_title),
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(4.dp))
        BiColorHorizontalDivider()
    }
}

@Preview
@Composable
private fun RegisterInputFlourContentPreview() {
    val dummyIngredients = getDummyIngredients()
    FlourRecipeTheme {
        Surface {
            RegisterInputFlourContent(
                modifier = Modifier,
                onAddClick = {},
                ingredients = dummyIngredients
            )
        }
    }
}
