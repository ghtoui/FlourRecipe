package com.ghtoui.flourRecipe.model.recipe

/**
 * 作成手順
 *
 * 手順の説明がメイン, メモはサブ程度
 *
 * @property name 手順名
 * @property description 手順の説明
 * @property memo メモ
 */
data class RecipeProcess(
    val name: String,
    val description: String,
    val memo: String?,
)
