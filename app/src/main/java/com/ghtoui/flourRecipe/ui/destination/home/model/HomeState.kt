package com.ghtoui.flourRecipe.ui.destination.home.model

import com.ghtoui.domain.model.recipe.FlourRecipe

/**
 * ホームの状態
 *
 * @property flourRecipes レシピのリスト
 */
internal data class HomeState(
    val flourRecipes: List<FlourRecipe>
) {
    companion object {
        fun initial(): HomeState = HomeState(
            flourRecipes = emptyList()
        )
    }
}
