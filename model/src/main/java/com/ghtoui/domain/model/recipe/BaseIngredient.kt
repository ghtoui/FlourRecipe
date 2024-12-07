package com.ghtoui.domain.model.recipe

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
data class BaseIngredient(
    val id: Int,
    val name: String,
    val calorie: Int,
    val baseQuantity: Int,
    val unit: String,
)
