package com.ghtoui.flourRecipe.ui.destination.home.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun IngredientContent(
    servings: Int,
    recipeIngredients: List<RecipeIngredient>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        IngredientTitle(
            servings = servings
        )
        Spacer(modifier = Modifier.height(16.dp))
        recipeIngredients.forEach { recipeIngredient ->
            Column {
                IngredientItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    recipeIngredient = recipeIngredient
                )
                HorizontalDivider()
            }
        }
    }
}

@Composable
private fun IngredientTitle(
    servings: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(id = R.string.ingredient),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = "$servings",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = stringResource(id = R.string.servings_unit),
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
        Row {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.secondary
            )
            HorizontalDivider(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
private fun IngredientContentPreview() {
    val dummyIngredients = getDummyIngredients()
    FlourRecipeTheme {
        Surface {
            IngredientContent(
                modifier = Modifier.width(200.dp),
                recipeIngredients = dummyIngredients,
                servings = 10,
            )
        }
    }
}
