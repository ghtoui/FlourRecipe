package com.ghtoui.flourRecipe.model.recipe

import java.time.ZonedDateTime

/**
 * 小麦粉のレシピ
 *
 * @property id ID
 * @property name レシピ名
 * @property path 完成画像パス
 * @property lastCreateDate 最後にレシピのものを作成した日
 * @property createRecipeDate レシピを作成した日
 * @property recipeDetail レシピ詳細
 * @property count 作成回数
 * @property isFavorite お気に入りか
 * @property recipeCategory レシピのカテゴリ
 * @property createTime 作成時間
 */
data class FlourRecipe(
    val id: Int,
    val name: String,
    val path: String?,
    val lastCreateDate: ZonedDateTime,
    val createRecipeDate: ZonedDateTime,
    val recipeDetail: RecipeDetail,
    val count: Int,
    val isFavorite: Boolean,
    val recipeCategory: RecipeCategory,
    val createTime: Int?,
)
