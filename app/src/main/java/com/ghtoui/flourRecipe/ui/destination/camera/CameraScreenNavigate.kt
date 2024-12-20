package com.ghtoui.flourRecipe.ui.destination.camera

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

/**
 * カメラ画面のRoute
 */
@Serializable
data object CameraScreenRoute

fun NavGraphBuilder.cameraScreen() {
    composable<CameraScreenRoute> {
        CameraScreen()
    }
}

fun NavHostController.navigateToCameraScreen() {
    navigate(CameraScreenRoute)
}
