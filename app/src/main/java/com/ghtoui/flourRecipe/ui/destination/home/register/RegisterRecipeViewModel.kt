package com.ghtoui.flourRecipe.ui.destination.home.register

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.ui.destination.home.register.model.RegisterRecipeState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class RegisterRecipeViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val recipeImage: MutableStateFlow<Bitmap?> = MutableStateFlow(null)

    private val recipeIngredients: MutableStateFlow<List<RecipeIngredient>> = MutableStateFlow(
        emptyList()
    )

    // 状態
    val state: StateFlow<RegisterRecipeState> = combine(
        recipeImage,
        recipeIngredients,
        ::RegisterRecipeState,
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = RegisterRecipeState.initial()
    )

    /**
     * Uriから画像に変換する
     *
     * @param uri
     */
    fun onSelectFlourRecipeImage(uri: Uri) {
        val source = ImageDecoder
            .createSource(
                context.contentResolver,
                uri
            )
        recipeImage.update {
            ImageDecoder.decodeBitmap(source)
        }
    }

    /**
     * 選択されている画像を削除する
     */
    fun onDeleteSelectFlourRecipeImage() {
        recipeImage.update { null }
    }
}
