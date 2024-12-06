package com.ghtoui.domain.model.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghtoui.flourRecipe.model.recipe.BaseIngredient

/**
 * 基礎となる材料の情報
 *
 * 基礎の量毎のカロリーを計算できるようにする
 * eg: 100cal / 100g -> [calorie]: 100, [baseQuantity]: 100
 *
 * @property id ID
 * @property name 名前
 * @property calorie カロリー
 * @property baseQuantity 基礎の量
 * @property unit 単位
 */
@Entity
data class BaseIngredient(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "calorie") val calorie: Int,
    @ColumnInfo(name = "base_quantity") val baseQuantity: Int,
    @ColumnInfo(name = "unit") val unit: String,
) {
    fun toDomain(): BaseIngredient = BaseIngredient(
        id = id,
        name = name,
        calorie = calorie,
        baseQuantity = baseQuantity,
        unit = unit,
    )
}
