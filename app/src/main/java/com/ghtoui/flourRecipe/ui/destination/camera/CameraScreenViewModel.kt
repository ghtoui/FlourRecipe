package com.ghtoui.flourRecipe.ui.destination.camera

import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghtoui.domain.usecase.GetRecipeImageUseCase
import com.ghtoui.domain.usecase.TakeRecipePictureUseCase
import com.ghtoui.flourRecipe.model.camera.CameraState
import com.ghtoui.flourRecipe.ui.destination.camera.model.CameraScreenEvent
import com.ghtoui.flourRecipe.ui.destination.camera.model.CameraScreenState
import com.ghtoui.flourRecipe.ui.destination.camera.model.ImageRotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CameraScreenViewModel @Inject constructor(
    getRecipeImageUseCase: GetRecipeImageUseCase,
    private val takeRecipePictureUseCase: TakeRecipePictureUseCase,
) : ViewModel() {
    private val _event: MutableSharedFlow<CameraScreenEvent> = MutableSharedFlow()
    val event: SharedFlow<CameraScreenEvent> = _event.asSharedFlow()

    private val recipeImage: StateFlow<Bitmap?> = getRecipeImageUseCase()

    private val cameraState: MutableStateFlow<CameraState> = MutableStateFlow(CameraState.Open)

    val state: StateFlow<CameraScreenState> = combine(
        recipeImage,
        cameraState,
        ::CameraScreenState,
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = CameraScreenState.initial(),
    )

    /**
     * カメラを開く
     */
    fun openCamera() {
        cameraState.update {
            CameraState.Open
        }
    }

    /**
     * カメラ撮影
     *
     * @param imageProxy 撮影した情報をそのまま
     */
    fun onTakePicture(imageProxy: ImageProxy) {
        takeRecipePictureUseCase(
            fixRotate(imageProxy),
        ).apply {
            cameraState.update {
                CameraState.Close
            }
        }
    }

    /**
     * 左に回す
     */
    fun imageLeftRotate() {
        rotateImage(imageRotation = ImageRotation.Left)
    }

    /**
     * 右に回す
     */
    fun imageRightRotate() {
        rotateImage(imageRotation = ImageRotation.Right)
    }

    /**
     * 編集を完了する
     */
    fun confirmEditImage() {
        recipeImage.value?.let {
            takeRecipePictureUseCase(
                it,
            ).apply {
                viewModelScope.launch {
                    _event.emit(CameraScreenEvent.TakePicture)
                }
            }
        }
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
            false,
        )
    }

    private fun rotateImage(
        imageRotation: ImageRotation,
    ) {
        recipeImage.value?.let { recipeImage ->
            val matrix = Matrix()
            matrix.postRotate(
                when (imageRotation) {
                    ImageRotation.Right -> 90f
                    ImageRotation.Left -> -90f
                },
            )
            val bitmap = Bitmap.createBitmap(
                recipeImage,
                0,
                0,
                recipeImage.width,
                recipeImage.height,
                matrix,
                false,
            )
            takeRecipePictureUseCase(bitmap)
        }
    }
}
