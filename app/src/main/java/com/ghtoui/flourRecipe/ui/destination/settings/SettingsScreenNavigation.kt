package com.ghtoui.flourRecipe.ui.destination.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SettingsScreenRoute

fun NavGraphBuilder.settingsScreen() {
    composable<SettingsScreenRoute> {
        SettingsScreen()
    }
}

fun NavHostController.navigateToSettings() {
    navigate(route = SettingsScreenRoute) {
        popUpTo(graph.id) {
            saveState = true
        }
        restoreState = true
    }
}
