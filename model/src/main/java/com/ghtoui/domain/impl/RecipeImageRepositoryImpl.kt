package com.ghtoui.domain.impl

import android.graphics.Bitmap
import com.ghtoui.domain.repository.RecipeImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RecipeImageRepositoryImpl @Inject constructor() : RecipeImageRepository {
    private val _recipeImage: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
    override val recipeImage: StateFlow<Bitmap?> = _recipeImage.asStateFlow()

    override fun takeRecipePicture(picture: Bitmap) {
        _recipeImage.update {
            picture
        }
    }

    override fun deleteRecipePicture() {
        _recipeImage.update { null }
    }
}
