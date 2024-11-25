package com.ghtoui.flourRecipe.ui.destination

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ghtoui.flourRecipe.ui.destination.home.HomeScreenRoute
import com.ghtoui.flourRecipe.ui.destination.home.homeScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = rememberNavController(),
        startDestination = HomeScreenRoute
    ) {
        homeScreen()
    }
}
