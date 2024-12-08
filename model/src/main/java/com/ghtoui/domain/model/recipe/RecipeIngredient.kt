package com.ghtoui.domain.model.recipe

/**
 * レシピの材料
 *
 * @property baseIngredient 基の材料情報
 * @property quantity 量
 */
data class RecipeIngredient(
    val baseIngredient: BaseIngredient,
    val quantity: Int,
)
