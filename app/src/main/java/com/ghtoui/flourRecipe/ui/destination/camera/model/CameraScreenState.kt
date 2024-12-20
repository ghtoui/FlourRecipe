package com.ghtoui.flourRecipe.ui.destination.camera.model

import android.graphics.Bitmap
import com.ghtoui.flourRecipe.model.camera.CameraState

/**
 * カメラ画面の状態
 *
 * @property recipeImage レシピ画像
 * @property cameraState カメラの状態
 */
internal data class CameraScreenState(
    val recipeImage: Bitmap?,
    val cameraState: CameraState,
) {
    companion object {
        fun initial(): CameraScreenState = CameraScreenState(
            recipeImage = null,
            cameraState = CameraState.Close,
        )
    }
}
