package com.ghtoui.domain.model.recipe

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * レシピ詳細
 *
 * @property recipeDetailId ID
 * @property recipeId レシピのID
 * @property servings 何人前
 * @property references 参考にしたもの
 */
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = FlourRecipe::class,
            parentColumns = ["recipeId"],
            childColumns = ["recipeDetailId"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class RecipeDetail(
    @PrimaryKey(autoGenerate = true) val recipeDetailId: Int = 0,
    val recipeId: Int,
    val servings: Int,
    val references: List<String>,
)
