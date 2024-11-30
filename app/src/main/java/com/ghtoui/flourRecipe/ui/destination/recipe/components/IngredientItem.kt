package com.ghtoui.flourRecipe.ui.destination.recipe.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.ui.destination.home.components.QuantityText
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun IngredientItem(
    recipeIngredient: RecipeIngredient,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = recipeIngredient.baseIngredient.name,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        QuantityText(
            quantity = recipeIngredient.quantity,
            unit = recipeIngredient.baseIngredient.unit,
        )
    }
}

@Preview
@Composable
private fun IngredientItemPreview() {
    val dummyIngredient = getDummyIngredients().first()
    FlourRecipeTheme {
        Surface {
            IngredientItem(
                modifier = Modifier.width(100.dp),
                recipeIngredient = dummyIngredient
            )
        }
    }
}
