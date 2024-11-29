package com.ghtoui.flourRecipe.model.recipe

/**
 * レシピ詳細
 *
 * @property id ID
 * @property ingredients レシピに使用する材料
 * @property recipeProcess 作成手順
 */
data class RecipeDetail(
    val id: Int,
    val ingredients: List<RecipeIngredient>,
    val recipeProcess: List<RecipeProcess>,
)
