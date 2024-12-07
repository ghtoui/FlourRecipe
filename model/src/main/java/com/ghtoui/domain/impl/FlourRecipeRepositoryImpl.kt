package com.ghtoui.domain.impl

import com.ghtoui.core.datas.room.dao.FlourRecipeDao
import com.ghtoui.domain.repository.FlourRecipeRepository
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FlourRecipeRepositoryImpl @Inject constructor(
    private val flourRecipeDao: FlourRecipeDao
) : FlourRecipeRepository {
    override suspend fun getRecipeList(): Flow<List<FlourRecipe>> {
        return flourRecipeDao.getAllFlourRecipe().map {
            it.map { allFlourRecipe->
                allFlourRecipe.toDomain()
            }
        }
    }

    override suspend fun saveRecipe(flourRecipe: FlourRecipe): Result<Unit> = runCatching {
        flourRecipeDao.insertFlourRecipe(flourRecipe = flourRecipe.toEntity())
    }
}
