package com.ghtoui.domain.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.RecipeProcess

/**
 * 作成手順
 *
 * 手順の説明がメイン, メモはサブ程度
 *
 * @property id ID
 * @property name 手順名
 * @property description 手順の説明
 * @property memo メモ
 */
@Entity
data class RecipeProcess(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "memo") val memo: String?,
) {
    fun toDomain(): RecipeProcess = RecipeProcess(
        name = name,
        description = description,
        memo = memo,
    )
}
