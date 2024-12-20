package com.ghtoui.flourRecipe.ui.destination.camera

import androidx.camera.core.ImageProxy
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.camera.CameraState
import com.ghtoui.flourRecipe.ui.components.CameraPreview
import com.ghtoui.flourRecipe.ui.destination.camera.component.ImageEditContent
import com.ghtoui.flourRecipe.ui.destination.camera.model.CameraScreenEvent
import com.ghtoui.flourRecipe.ui.destination.camera.model.CameraScreenState
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * カメラ画面
 */
@Composable
internal fun CameraScreen(
    mainNavController: NavHostController = LocalMainNavController.current,
    viewModel: CameraScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when(it) {
                CameraScreenEvent.TakePicture -> {
                    mainNavController.navigateUp()
                }
            }
        }
    }
    CameraScreen(
        state = state,
        modifier = Modifier,
        onTakePicture = viewModel::onTakePicture,
        onCloseCamera = mainNavController::navigateUp,
        onBackCameraClick = viewModel::openCamera,
        onLeftRotation = viewModel::imageLeftRotate,
        onRightRotation = viewModel::imageRightRotate,
        onConfirmClick = viewModel::confirmEditImage,
    )
}

@Composable
private fun CameraScreen(
    state: CameraScreenState,
    onCloseCamera: () -> Unit,
    onTakePicture: (ImageProxy) -> Unit,
    onRightRotation: () -> Unit,
    onLeftRotation: () -> Unit,
    onBackCameraClick: () -> Unit,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
    ) {
        when (state.cameraState) {
            CameraState.Open -> {
                CameraPreview(
                    modifier = Modifier,
                    onClose = onCloseCamera,
                    onTakePicture = onTakePicture,
                )
            }
            CameraState.Close -> {
                state.recipeImage?.let { recipeImage ->
                    ImageEditContent(
                        onBackCameraClick = onBackCameraClick,
                        onLeftRotation = onLeftRotation,
                        onRightRotation = onRightRotation,
                        recipeImage = recipeImage,
                        onConfirmClick = onConfirmClick,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CameraScreenPreview() {
    FlourRecipeTheme {
        Surface {
            CameraScreen(
                state = CameraScreenState.initial(),
                onCloseCamera = {},
                onTakePicture = {},
                modifier = Modifier,
                onBackCameraClick = {},
                onLeftRotation = {},
                onRightRotation = {},
                onConfirmClick = {},
            )
        }
    }
}
