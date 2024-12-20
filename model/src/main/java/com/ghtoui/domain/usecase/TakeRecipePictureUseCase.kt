package com.ghtoui.domain.usecase

import android.graphics.Bitmap
import com.ghtoui.domain.repository.RecipeImageRepository
import javax.inject.Inject

/**
 * レシピの写真を撮影する
 */
class TakeRecipePictureUseCase @Inject constructor(
    private val recipeImageRepository: RecipeImageRepository,
) {
    operator fun invoke(picture: Bitmap) = recipeImageRepository.takeRecipePicture(picture)
}
