package com.ghtoui.domain.usecase

import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.domain.repository.FlourRecipeRepository
import javax.inject.Inject

/**
 * レシピを保存する
 */
class SaveFlourRecipeUseCase @Inject constructor(
    private val flourRecipeRepository: FlourRecipeRepository,
) {
    suspend operator fun invoke(flourRecipe: FlourRecipe): Result<Unit> = flourRecipeRepository.saveRecipe(flourRecipe)
}
