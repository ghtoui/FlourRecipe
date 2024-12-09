package com.ghtoui.flourRecipe.ui.destination.home.recipe

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.ghtoui.flourRecipe.ui.destination.home.register.RegisterRecipeScreen
import kotlinx.serialization.Serializable

/**
 * レシピ登録のRoute
 */
@Serializable
data object RegisterRecipeRoute

fun NavGraphBuilder.registerRecipeScreen() {
    composable<RegisterRecipeRoute> {
        RegisterRecipeScreen()
    }
}

fun NavHostController.navigateToRegisterRecipe() {
    navigate(RegisterRecipeRoute)
}
