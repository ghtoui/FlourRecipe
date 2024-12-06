package com.ghtoui.domain.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.model.recipe.RecipeCategory
import java.time.ZonedDateTime

/**
 * 小麦粉のレシピ
 *
 * @property id ID
 * @property name レシピ名
 * @property imagePath 完成画像パス
 * @property lastCreateDate 最後にレシピのものを作成した日
 * @property createRecipeDate レシピを作成した日
 * @property recipeDetail レシピ詳細
 * @property count 作成回数
 * @property isFavorite お気に入りか
 * @property recipeCategory レシピのカテゴリ
 * @property createTime 作成時間
 */
@Entity
data class FlourRecipe (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "flour_recipe_name") val name: String,
    @ColumnInfo(name = "image_path") val imagePath: String,
    @ColumnInfo(name = "last_create_date") val lastCreateDate: ZonedDateTime,
    @ColumnInfo(name = "create_recipe_date") val createRecipeDate: ZonedDateTime,
    @ColumnInfo(name = "recipe_detail") val recipeDetail: RecipeDetail,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean,
    @ColumnInfo(name = "recipe_category") val recipeCategory: RecipeCategory,
    @ColumnInfo(name = "create_time") val createTime: Int?,
) {
    fun toDomain(): FlourRecipe = FlourRecipe(
        id = id,
        name = name,
        imagePath = imagePath,
        lastCreateDate = lastCreateDate,
        createRecipeDate = createRecipeDate,
        recipeDetail = recipeDetail.toDomain(),
        count = count,
        isFavorite = isFavorite,
        recipeCategory = recipeCategory,
        createTime = createTime,
    )
}
