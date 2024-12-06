package com.ghtoui.domain.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.RecipeIngredient

/**
 * レシピの材料
 *
 * @property id ID
 * @property baseIngredient 基の材料情報
 * @property quantity 量
 */
@Entity
data class RecipeIngredient(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "base_ingredient") val baseIngredient: BaseIngredient,
    @ColumnInfo(name = "quantity") val quantity: Int,
) {
    fun toDomain(): RecipeIngredient = RecipeIngredient(
        baseIngredient = baseIngredient.toDomain(),
        quantity = quantity,
    )
}
