package com.ghtoui.core.datas.model.recipe

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * 参照したもの
 *
 * @property referenceId ID
 * @property recipeDetailId レシピ詳細ID
 * @property reference 参照したものの情報
 */
@Entity(
    indices = [
        Index("recipeDetailId")
              ],
    foreignKeys = [
        ForeignKey(
            entity = RecipeDetail::class,
            parentColumns = ["recipeDetailId"],
            childColumns = ["recipeDetailId"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
internal data class Reference(
    @PrimaryKey(autoGenerate = true) val referenceId: Int = 0,
    val recipeDetailId: Int,
    val reference: String,
) {
    fun toDomain(): String = reference
}
