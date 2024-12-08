package com.ghtoui.domain.repository

import com.ghtoui.domain.model.recipe.FlourRecipe
import javax.inject.Inject

/**
 * レシピを保存する
 */
class SaveFlourRecipeUseCase @Inject constructor(
    private val flourRecipeRepository: FlourRecipeRepository
) {
    suspend operator fun invoke(flourRecipe: FlourRecipe): Result<Unit> = flourRecipeRepository.saveRecipe(flourRecipe)
}
