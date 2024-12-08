package com.ghtoui.core.datas.model.recipe

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = BaseIngredient::class,
            parentColumns = ["baseIngredientId"],
            childColumns = ["baseIngredientId"],
            onDelete = ForeignKey.RESTRICT
        )
    ]
)
internal data class BaseIngredient(
    @PrimaryKey(autoGenerate = true) val baseIngredientId: Int = 0,
    val name: String,
    val calorie: Int,
    val baseQuantity: Int,
    val unit: String,
) {
    fun toDomain(): com.ghtoui.domain.model.recipe.BaseIngredient = com.ghtoui.domain.model.recipe.BaseIngredient(
        id = baseIngredientId,
        name = name,
        calorie = calorie,
        baseQuantity = baseQuantity,
        unit = unit,
    )
}
