package com.ghtoui.core.datas.model.recipe

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * レシピの材料
 *
 * @property recipeIngredientId ID
 * @property recipeDetailId レシピ詳細のID
 * @property baseIngredientId 材料情報のID
 * @property quantity 量
 */
@Entity(
    indices = [
        Index("recipeDetailId"),
        Index("baseIngredientId"),
    ],
    foreignKeys = [
        ForeignKey(
            entity = RecipeDetail::class,
            parentColumns = ["recipeDetailId"],
            childColumns = ["recipeDetailId"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = BaseIngredient::class,
            parentColumns = ["baseIngredientId"],
            childColumns = ["baseIngredientId"],
        ),
    ],
)
internal data class RecipeIngredient(
    @PrimaryKey(autoGenerate = true) val recipeIngredientId: Int = 0,
    val recipeDetailId: Int,
    val baseIngredientId: Int,
    val quantity: Int,
)
