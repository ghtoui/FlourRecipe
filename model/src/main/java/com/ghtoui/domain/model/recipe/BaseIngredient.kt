package com.ghtoui.domain.model.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.BaseIngredient

/**
 * 基礎となる材料の情報
 *
 * 基礎の量毎のカロリーを計算できるようにする
 * eg: 100cal / 100g -> [calorie]: 100, [baseQuantity]: 100
 *
 * @property baseIngredientId ID
 * @property name 名前
 * @property calorie カロリー
 * @property baseQuantity 基礎の量
 * @property unit 単位
 */
@Entity
data class BaseIngredient(
    @PrimaryKey(autoGenerate = true) val baseIngredientId: Int = 0,
    val name: String,
    val calorie: Int,
    val baseQuantity: Int,
    val unit: String,
) {
    fun toDomain(): BaseIngredient = BaseIngredient(
        id = baseIngredientId,
        name = name,
        calorie = calorie,
        baseQuantity = baseQuantity,
        unit = unit,
    )
}
