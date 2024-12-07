package com.ghtoui.domain.model.recipe

import androidx.room.Embedded
import androidx.room.Relation

data class IngredientWithBase(
    @Embedded val ingredient: RecipeIngredient,
    @Relation(
        parentColumn = "recipeIngredientId",
        entityColumn = "baseIngredientId",
    )
    val baseIngredient: BaseIngredient,
) {
    fun toDomain(): com.ghtoui.flourRecipe.model.recipe.RecipeIngredient = com.ghtoui.flourRecipe.model.recipe.RecipeIngredient(
        baseIngredient = baseIngredient.toDomain(),
        quantity = ingredient.quantity
    )
}
