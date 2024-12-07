package com.ghtoui.core.datas.model.recipe

import androidx.room.Embedded
import androidx.room.Relation

internal data class FlourRecipeDetailRelation(
    @Embedded val recipeDetail: RecipeDetail,
    @Relation(
        entity = RecipeIngredient::class,
        parentColumn = "recipeDetailId",
        entityColumn = "recipeDetailId",
    )
    val ingredients: List<IngredientWithBase>,
    @Relation(
        parentColumn = "recipeDetailId",
        entityColumn = "recipeDetailId",
    )
    val recipeProcess: List<RecipeProcess>,
    @Relation(
        parentColumn = "recipeDetailId",
        entityColumn = "recipeDetailId",
    )
    val references: List<Reference>,
) {
    fun toDomain(): com.ghtoui.domain.model.recipe.RecipeDetail =
        com.ghtoui.domain.model.recipe.RecipeDetail(
            servings = recipeDetail.servings,
            references = references.map { it.toDomain() },
            recipeProcess = recipeProcess.map { it.toDomain() },
            ingredients = ingredients.map { it.toDomain() }
        )
}
