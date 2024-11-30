package com.ghtoui.flourRecipe.ui.destination.home.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.ui.destination.home.detail.components.IngredientContent
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun HomeDetailScreen(
    mainNavController: NavHostController = LocalMainNavController.current
) {
    HomeDetailScreen(
        modifier = Modifier,
        recipeIngredients = getDummyIngredients()
    )
}

@Composable
private fun HomeDetailScreen(
    recipeIngredients: List<RecipeIngredient>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        IngredientContent(
            modifier = Modifier.fillMaxWidth(),
            recipeIngredients = recipeIngredients,
            servings = 10
        )
    }
}

@Preview
@Composable
private fun HomeDetailScreenPreview() {
    val dummyIngredients = getDummyIngredients()
    FlourRecipeTheme {
        Surface {
            HomeDetailScreen(
                modifier = Modifier,
                recipeIngredients = dummyIngredients,
            )
        }
    }
}
