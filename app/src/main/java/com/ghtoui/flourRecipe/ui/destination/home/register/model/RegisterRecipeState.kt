package com.ghtoui.flourRecipe.ui.destination.home.register.model

import android.graphics.Bitmap
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.model.camera.CameraState

/**
 * レシピ登録画面の状態
 *
 * @property recipeImage レシピの画像
 * @property recipeIngredients レシピの材料
 * @property cameraState カメラの状態
 */
internal data class RegisterRecipeState(
    val recipeImage: Bitmap?,
    val recipeIngredients: List<RecipeIngredient>,
    val cameraState: CameraState,
) {
    companion object {
        fun initial(): RegisterRecipeState = RegisterRecipeState(
            recipeImage = null,
            recipeIngredients = emptyList(),
            cameraState = CameraState.Close,
        )
    }
}
