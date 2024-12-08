package com.ghtoui.core.datas.model.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.core.extensions.long.formatDateTime
import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.domain.model.recipe.RecipeCategory

/**
 * 小麦粉のレシピ
 *
 * @property recipeId ID
 * @property name レシピ名
 * @property imagePath 完成画像パス
 * @property lastCreateDate 最後にレシピのものを作成した日
 * @property createRecipeDate レシピを作成した日
 * @property count 作成回数
 * @property isFavorite お気に入りか
 * @property recipeCategory レシピのカテゴリ
 * @property createTime 作成時間
 */
@Entity
internal data class FlourRecipe(
    @PrimaryKey(autoGenerate = true) val recipeId: Int = 0,
    val name: String,
    val imagePath: String,
    val lastCreateDate: Long,
    val createRecipeDate: Long,
    val count: Int,
    val isFavorite: Boolean,
    val recipeCategory: RecipeCategory,
    val createTime: Int?,
) {
    fun toDomain(): FlourRecipe = FlourRecipe(
        id = recipeId,
        name = name,
        imagePath = imagePath,
        lastCreateDate = lastCreateDate.formatDateTime(),
        createRecipeDate = createRecipeDate.formatDateTime(),
        count = count,
        isFavorite = isFavorite,
        recipeCategory = recipeCategory,
        createTime = createTime,
    )
}
