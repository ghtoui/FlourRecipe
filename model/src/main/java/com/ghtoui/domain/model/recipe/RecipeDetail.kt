package com.ghtoui.domain.model.recipe

/**
 * レシピ詳細
 *
 * @property ingredients レシピに使用する材料
 * @property recipeProcess 作成手順
 * @property servings 何人前
 * @property references 参考にしたもの
 */
data class RecipeDetail(
    val ingredients: List<RecipeIngredient>,
    val recipeProcess: List<RecipeProcess>,
    val servings: Int,
    val references: List<String>,
)
