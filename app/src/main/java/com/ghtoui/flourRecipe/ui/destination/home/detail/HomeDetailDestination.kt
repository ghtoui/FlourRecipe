package com.ghtoui.flourRecipe.ui.destination.home.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.ghtoui.flourRecipe.ui.destination.home.HomeScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomeDetailRoute

internal fun NavGraphBuilder.homeDetailScreen() {
    composable<HomeScreenRoute> {
        HomeDetailScreen()
    }
}

internal fun NavHostController.navigateToHomeDetail() {
    navigate(route = HomeDetailRoute)
}
