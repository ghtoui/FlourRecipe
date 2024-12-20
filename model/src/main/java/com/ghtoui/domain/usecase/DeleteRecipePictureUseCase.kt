package com.ghtoui.domain.usecase

import com.ghtoui.domain.repository.RecipeImageRepository
import javax.inject.Inject

/**
 * 撮影した写真を削除
 */
class DeleteRecipePictureUseCase @Inject constructor(
    private val recipeImageRepository: RecipeImageRepository
) {
    operator fun invoke() = recipeImageRepository.deleteRecipePicture()
}
