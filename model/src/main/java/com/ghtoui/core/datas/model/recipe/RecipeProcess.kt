package com.ghtoui.core.datas.model.recipe

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ghtoui.domain.model.recipe.RecipeProcess

/**
 * 作成手順
 *
 * 手順の説明がメイン, メモはサブ程度
 *
 * @property id ID
 * @property recipeDetailId レシピ詳細のID
 * @property name 手順名
 * @property description 手順の説明
 * @property memo メモ
 */
@Entity(
    indices = [
        Index("recipeDetailId"),
    ],
    foreignKeys = [
        ForeignKey(
            entity = RecipeDetail::class,
            parentColumns = ["recipeDetailId"],
            childColumns = ["recipeDetailId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
internal data class RecipeProcess(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val recipeDetailId: Int,
    val name: String,
    val description: String,
    val memo: String?,
) {
    fun toDomain(): RecipeProcess = RecipeProcess(
        name = name,
        description = description,
        memo = memo,
    )
}
