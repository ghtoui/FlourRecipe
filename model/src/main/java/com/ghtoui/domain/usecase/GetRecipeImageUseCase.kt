package com.ghtoui.domain.usecase

import android.graphics.Bitmap
import com.ghtoui.domain.repository.RecipeImageRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * 写真の状態を取得
 */
class GetRecipeImageUseCase @Inject constructor(
    private val cameraRepository: RecipeImageRepository,
) {
    operator fun invoke(): StateFlow<Bitmap?> = cameraRepository.recipeImage
}
