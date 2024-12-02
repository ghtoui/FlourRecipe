package com.ghtoui.flourRecipe.ui.destination.home.preview

import com.ghtoui.flourRecipe.model.recipe.BaseIngredient
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.model.recipe.RecipeCategory
import com.ghtoui.flourRecipe.model.recipe.RecipeDetail
import com.ghtoui.flourRecipe.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.model.recipe.RecipeProcess
import java.time.ZonedDateTime

internal fun getDummyRecipes(count: Int = 5): List<FlourRecipe> {
    return (0..count).map {
        getFlourRecipe(it)
    }
}

internal fun getDummyIngredients(): List<RecipeIngredient> = listOf(
    RecipeIngredient(
        baseIngredient = getBaseIngredient(1),
        quantity = 100,
    ),
    RecipeIngredient(
        baseIngredient = getBaseIngredient(2),
        quantity = 100,
    ),
    RecipeIngredient(
        baseIngredient = getBaseIngredient(3),
        quantity = 100,
    ),
    RecipeIngredient(
        baseIngredient = getBaseIngredient(4),
        quantity = 100,
    ),
)

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
    return BaseIngredient(
        id = id,
        name = ingredientMap.keys.toList()[ingredientMap.keys.size % id],
        calorie = ingredientMap.values.toList()[ingredientMap.values.size % id],
        baseQuantity = 100,
        unit = "g",
    )
}
