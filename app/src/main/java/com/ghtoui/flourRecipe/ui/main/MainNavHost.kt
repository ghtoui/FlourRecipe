package com.ghtoui.flourRecipe.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.ui.camerax.cameraXScreen
import com.ghtoui.flourRecipe.ui.destination.home.HomeScreenRoute
import com.ghtoui.flourRecipe.ui.destination.home.homeScreen
import com.ghtoui.flourRecipe.ui.destination.home.recipe.recipeScreen
import com.ghtoui.flourRecipe.ui.destination.home.register.registerRecipeScreen
import com.ghtoui.flourRecipe.ui.destination.settings.settingsScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController = LocalMainNavController.current,
) {
    NavHost(
        modifier = modifier,
        navController = mainNavController,
        startDestination = HomeScreenRoute,
    ) {
        homeScreen()
        settingsScreen()
        recipeScreen()
        registerRecipeScreen()
        cameraXScreen()
    }
}
