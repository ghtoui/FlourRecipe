package com.ghtoui.domain.model.recipe

import androidx.room.Embedded
import androidx.room.Relation

data class FlourRecipeDetailRelation(
    @Embedded val recipeDetail: RecipeDetail,
    @Relation(
        parentColumn = "recipeDetailID",
        entityColumn = "recipeDetailID",
    )
    val ingredients: List<IngredientWithBase>,
    @Relation(
        parentColumn = "recipeDetailID",
        entityColumn = "recipeDetailID",
    )
    val recipeProcess: List<RecipeProcess>
) {
    fun toDomain(): com.ghtoui.flourRecipe.model.recipe.RecipeDetail = com.ghtoui.flourRecipe.model.recipe.RecipeDetail(
        servings = recipeDetail.servings,
        references = recipeDetail.references,
        recipeProcess = recipeProcess.map { it.toDomain() },
        ingredients = ingredients.map { it.toDomain() }
    )
}
