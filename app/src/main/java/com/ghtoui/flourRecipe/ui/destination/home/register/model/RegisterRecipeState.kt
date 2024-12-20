package com.ghtoui.flourRecipe.ui.destination.home.register.model

import android.graphics.Bitmap
import com.ghtoui.domain.model.recipe.RecipeIngredient

/**
 * レシピ登録画面の状態
 *
 * @property recipeImage レシピの画像
 * @property recipeIngredients レシピの材料
 */
internal data class RegisterRecipeState(
    val recipeImage: Bitmap?,
    val recipeIngredients: List<RecipeIngredient>,
) {
    companion object {
        fun initial(): RegisterRecipeState = RegisterRecipeState(
            recipeImage = null,
            recipeIngredients = emptyList(),
        )
    }
}
