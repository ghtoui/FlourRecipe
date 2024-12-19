package com.ghtoui.flourRecipe.ui.components

import android.Manifest
import android.view.OrientationEventListener
import android.view.Surface.ROTATION_0
import android.view.Surface.ROTATION_180
import android.view.Surface.ROTATION_270
import android.view.Surface.ROTATION_90
import androidx.camera.compose.CameraXViewfinder
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.core.SurfaceRequest
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun CameraPreview(
    onTakePicture: (ImageProxy) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cameraPermissionState: PermissionState =
        rememberPermissionState(Manifest.permission.CAMERA)

    // カメラ使用許可を得る
    LaunchedEffect(Unit) {
        if (!cameraPermissionState.status.isGranted &&
            !cameraPermissionState.status.shouldShowRationale
        ) {
            cameraPermissionState.launchPermissionRequest()
        }
    }

    val context = LocalContext.current

    var currentSurfaceRequest: SurfaceRequest? by remember { mutableStateOf(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraExecutor: ExecutorService = remember { Executors.newSingleThreadExecutor() }
    val imageCapture = remember {
        ImageCapture.Builder()
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            .build()
    }
    val preview = remember {
        Preview.Builder()
            .build()
            .apply {
                setSurfaceProvider {
                    currentSurfaceRequest = it
                }
            }
    }

    val scope = rememberCoroutineScope()

    // カメラを指定する
    LifecycleStartEffect(Unit) {
        var cameraProvider: ProcessCameraProvider? = null

        scope.launch {
            cameraProvider = ProcessCameraProvider.awaitInstance(context)
            cameraProvider!!.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageCapture,
            )
        }

        onStopOrDispose {
            cameraProvider?.unbindAll()
        }
    }

    currentSurfaceRequest?.let { surfaceRequest ->
        Box(
            modifier = modifier,
        ) {
            CameraXViewfinder(
                surfaceRequest = surfaceRequest,
                modifier = Modifier
                    .fillMaxSize(),
            )
            CameraFrame(
                onTakePicture = {
                    imageCapture.takePicture(
                        cameraExecutor,
                        object : ImageCapture.OnImageCapturedCallback() {
                            override fun onCaptureSuccess(image: ImageProxy) {
                                onTakePicture(image)
                                image.close()
                            }

                            override fun onError(exception: ImageCaptureException) {
                                exception.printStackTrace()
                            }
                        },
                    )
                },
                onClose = onClose,
            )
        }
    }
}

@Composable
private fun BoxScope.CameraFrame(
    onTakePicture: () -> Unit,
    onClose: () -> Unit,
) {
    IconButton(
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
            )
            .padding(start = 12.dp),
        onClick = onClose,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_close),
            contentDescription = stringResource(R.string.description_close),
            tint = Color.White,
        )
    }
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
            )
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape,
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .clickable(
                    role = Role.Button,
                    onClick = onTakePicture,
                ),
        )
    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
private fun CameraButtonPreview() {
    FlourRecipeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            CameraFrame(
                onClose = {},
                onTakePicture = {},
            )
        }
    }
}
