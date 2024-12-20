package com.ghtoui.flourRecipe.ui.destination.camera

import androidx.camera.core.ImageProxy
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
        onCloseCamera = mainNavController::navigateUp
    )
}

@Composable
private fun CameraScreen(
    state: CameraScreenState,
    onCloseCamera: () -> Unit,
    onTakePicture: (ImageProxy) -> Unit,
    modifier: Modifier = Modifier
) {
    when (state.cameraState) {
        CameraState.Open -> {
            CameraPreview(
                modifier = modifier,
                onClose = onCloseCamera,
                onTakePicture = onTakePicture,
            )
        }
        CameraState.Close -> Unit
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
            )
        }
    }
}
