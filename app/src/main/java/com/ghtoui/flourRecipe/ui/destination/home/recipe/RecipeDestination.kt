package com.ghtoui.flourRecipe.ui.destination.home.recipe

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class RecipeScreenRoute(
    val flourId: Int,
)

internal fun NavGraphBuilder.recipeScreen() {
    composable<RecipeScreenRoute> {
        RecipeScreen()
    }
}

internal fun NavHostController.navigateToRecipe(recipeId: Int) {
    navigate(route = RecipeScreenRoute(flourId = recipeId))
}
