package com.ghtoui.domain.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.RecipeDetail

/**
 * レシピ詳細
 *
 * @property id ID
 * @property ingredients レシピに使用する材料
 * @property recipeProcess 作成手順
 * @property servings 何人前
 * @property references 参考にしたもの
 */
@Entity
data class RecipeDetail(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "ingredients") val ingredients: List<RecipeIngredient>,
    @ColumnInfo(name = "recipeProcess") val recipeProcess: List<RecipeProcess>,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "references") val references: List<String>,
) {
    fun toDomain(): RecipeDetail = RecipeDetail(
        ingredients = ingredients.map { it.toDomain() },
        recipeProcess = recipeProcess.map { it.toDomain() },
        servings = servings,
        references = references,
    )
}
