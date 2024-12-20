package com.ghtoui.flourRecipe.ui.destination.camera

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
    composable<CameraScreenRoute>(
        enterTransition = {
            slideInVertically(
                animationSpec = tween(
                    500,
                    easing = LinearEasing,
                ),
                // デフォルトは上から下なので，下から上に出るようにしたい
                initialOffsetY = { height ->
                    height
                },
            )
        },
        exitTransition = {
            slideOutVertically(
                animationSpec = tween(
                    500,
                    easing = LinearEasing,
                ),
                // デフォルトは上に閉じるので，下に閉じるようにしたい
                targetOffsetY = { height ->
                    +height
                },
            )
        },
    ) {
        CameraScreen()
    }
}

fun NavHostController.navigateToCameraScreen() {
    navigate(CameraScreenRoute)
}
