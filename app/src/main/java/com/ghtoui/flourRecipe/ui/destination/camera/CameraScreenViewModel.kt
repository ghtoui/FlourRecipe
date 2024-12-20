package com.ghtoui.flourRecipe.ui.destination.camera

import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghtoui.domain.usecase.GetRecipeImageUseCase
import com.ghtoui.domain.usecase.TakeRecipePictureUseCase
import com.ghtoui.flourRecipe.model.camera.CameraState
import com.ghtoui.flourRecipe.ui.destination.camera.model.CameraScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class CameraScreenViewModel @Inject constructor(
    getRecipeImageUseCase: GetRecipeImageUseCase,
    private val takeRecipePictureUseCase: TakeRecipePictureUseCase,
) : ViewModel() {
    private val cameraState: MutableStateFlow<CameraState> = MutableStateFlow(CameraState.Open)

    val state: StateFlow<CameraScreenState> = combine(
        getRecipeImageUseCase(),
        cameraState,
        ::CameraScreenState
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = CameraScreenState.initial()
    )

    /**
     * カメラを開く
     */
    fun openCamera() {
        cameraState.update {
            CameraState.Open
        }
    }

    fun onTakePicture(imageProxy: ImageProxy) {
        takeRecipePictureUseCase(
            fixRotate(imageProxy)
        )
    }

    private fun fixRotate(imageProxy: ImageProxy): Bitmap {
        val rotation = imageProxy.imageInfo.rotationDegrees
        val takePicBitMap = imageProxy.toBitmap()

        val matrix = Matrix()
        matrix.postRotate(rotation.toFloat())
        return Bitmap.createBitmap(
            takePicBitMap,
            0,
            0,
            imageProxy.width,
            imageProxy.height,
            matrix,
            false
        )
    }
}
