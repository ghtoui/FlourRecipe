package com.ghtoui.model.impl

import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.model.repository.FlourRecipeRepository
import javax.inject.Inject

class FlourRecipeRepositoryImpl @Inject constructor() : FlourRecipeRepository {
    override suspend fun getRecipeList(): Result<List<FlourRecipe>> = runCatching {
        TODO("Not yet implemented")
    }

    override suspend fun saveRecipe(): Result<Unit> = runCatching {
        TODO("Not yet implemented")
    }
}
