package com.ghtoui.domain.usecase

import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.domain.repository.FlourRecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * レシピのリストを取得する
 */
class GetRecipeListUseCase @Inject constructor(
    private val flourRecipeRepository: FlourRecipeRepository
) {
    operator fun invoke(): Flow<List<FlourRecipe>> = flourRecipeRepository.getRecipeList()
}
