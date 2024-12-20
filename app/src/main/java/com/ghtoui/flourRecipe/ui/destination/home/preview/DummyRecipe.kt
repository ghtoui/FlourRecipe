package com.ghtoui.flourRecipe.ui.destination.home.preview

import com.ghtoui.domain.model.recipe.BaseIngredient
import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.domain.model.recipe.IngredientCategory
import com.ghtoui.domain.model.recipe.RecipeCategory
import com.ghtoui.domain.model.recipe.RecipeDetail
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.domain.model.recipe.RecipeProcess
import java.time.ZonedDateTime

internal fun getDummyRecipes(count: Int = 5): List<FlourRecipe> {
    return (0..count).map {
        getFlourRecipe(it)
    }
}

internal fun getDummyIngredients(): List<RecipeIngredient> = (1..10).map {
    RecipeIngredient(
        baseIngredient = getBaseIngredient(it),
        quantity = 100,
    )
}

internal fun getDummyProcess(): List<RecipeProcess> = listOf(
    RecipeProcess(
        name = "粉を入れます",
        description = "小麦粉とドライイーストを入れます",
        memo = "よく混ぜると良いです",
    ),
    RecipeProcess(
        name = "水を入れます",
        description = "よく混ぜた粉に水を入れます",
        memo = null,
    ),
    RecipeProcess(
        name = "こねる",
        description = "手につかなくなるまでこねます",
        memo = "コネ板を使って，伸ばすようにこねると良い",
    ),
)

private fun getFlourRecipe(id: Int): FlourRecipe = FlourRecipe(
    id = id,
    imagePath = "",
    name = "パン_$id",
    count = 10,
    createRecipeDate = ZonedDateTime.now(),
    lastCreateDate = ZonedDateTime.now(),
    recipeCategory = RecipeCategory.Noodle,
    createTime = if (id % 2 == 0) 10 else null,
    isFavorite = id % 2 == 0,
    recipeDetail = getRecipeDetails(),
)

private fun getRecipeDetails(): RecipeDetail = RecipeDetail(
    recipeProcess = getDummyProcess(),
    ingredients = getDummyIngredients(),
    servings = 10,
    references = listOf(
        "https://example.com",
        "パン作りの本 2ページ目",
        "パン作りの本 3ページ目",
        "パン作りの本 4ページ目",
    ),
)

private fun getBaseIngredient(id: Int): BaseIngredient {
    val ingredientMap: Map<String, Int> = mapOf(
        "小麦粉" to 368,
        "砂糖" to 386,
        "水" to 0,
        "塩" to 0,
    )
    val name = ingredientMap.keys.toList()[id % ingredientMap.keys.size]
    return BaseIngredient(
        id = id,
        name = name,
        calorie = ingredientMap.values.toList()[id % ingredientMap.values.size],
        baseQuantity = 100,
        unit = "g",
        ingredientCategory = if (name == "小麦粉") IngredientCategory.Flour else IngredientCategory.Other,
    )
}
