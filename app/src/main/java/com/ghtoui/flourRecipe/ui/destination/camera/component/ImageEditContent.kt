package com.ghtoui.flourRecipe.ui.destination.camera.component

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * 画像を編集する
 *
 * @param onRightRotation 画像を右へ回転
 * @param onLeftRotation 画像を左へ回転
 * @param onBackCameraClick 戻る
 * @param onConfirmClick 編集完了
 * @param recipeImage レシピの画像
 * @param modifier [Modifier]
 */
@Composable
internal fun ImageEditContent(
    onRightRotation: () -> Unit,
    onLeftRotation: () -> Unit,
    onBackCameraClick: () -> Unit,
    onConfirmClick: () -> Unit,
    recipeImage: Bitmap,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Image(
            modifier = Modifier
                .fillMaxSize(),
            bitmap = recipeImage.asImageBitmap(),
            contentDescription = stringResource(R.string.description_take_image),
            contentScale = ContentScale.Fit,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 12.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.TopStart),
                onClick = onBackCameraClick
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = stringResource(R.string.description_back_navigation)
                )
            }
            RotationBottomBar(
                onRightRotation = onRightRotation,
                onLeftRotation = onLeftRotation,
                onConfirmClick = onConfirmClick,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun RotationBottomBar(
    onRightRotation: () -> Unit,
    onLeftRotation: () -> Unit,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        // 編集完了アイコンのサイズだけずらす
        Spacer(modifier = Modifier.width(40.dp))
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onLeftRotation,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_left_rotate),
                contentDescription = stringResource(R.string.description_rotate_left_image)
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
            onClick = onRightRotation,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_right_rotate),
                contentDescription = stringResource(R.string.description_rotate_right_image)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onConfirmClick,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_circle_check),
                contentDescription = stringResource(R.string.description_edit_complete)
            )
        }
    }
}

@Preview
@Composable
private fun ImageEditContentPreview() {
    FlourRecipeTheme {
        Surface {
            ImageEditContent(
                modifier = Modifier,
                onRightRotation = {},
                onLeftRotation = {},
                onBackCameraClick = {},
                onConfirmClick = {},
                recipeImage = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888).apply {
                    Canvas(this).drawColor(Color.RED)
                },
            )
        }
    }
}
