package com.ghtoui.core.datas.model.recipe

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

internal data class IngredientWithBase(
    @Embedded val ingredient: RecipeIngredient,
    @Relation(
        parentColumn = "baseIngredientId",
        entityColumn = "baseIngredientId",
        associateBy = Junction(RecipeIngredient::class),
    )
    val baseIngredient: BaseIngredient,
) {
    fun toDomain(): com.ghtoui.domain.model.recipe.RecipeIngredient =
        com.ghtoui.domain.model.recipe.RecipeIngredient(
            baseIngredient = baseIngredient.toDomain(),
            quantity = ingredient.quantity,
        )
}
