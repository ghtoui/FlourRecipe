package com.ghtoui.flourRecipe.ui.destination.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreenRoute

fun NavGraphBuilder.homeScreen() {
    composable<HomeScreenRoute> {
        HomeScreen()
    }
}
