package com.ghtoui.flourRecipe.ui.destination.home.register.components

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun RegisterFlourRecipeImageContent(
    flourRecipeImage: Bitmap?,
    onSelectFlourRecipeImage: (Uri) -> Unit,
    onDeleteFlourRecipeImage: () -> Unit,
    onOpenCamera: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        RegisterInputTitle(
            title = stringResource(R.string.register_recipe_input_image_title),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            if (flourRecipeImage == null) {
                RegisterImageButtons(
                    onSelectFlourRecipeImage = onSelectFlourRecipeImage,
                    onClickTakePicture = onOpenCamera,
                )
            } else {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .weight(1f),
                    bitmap = flourRecipeImage.asImageBitmap(),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    modifier = Modifier.align(Alignment.Bottom),
                    onClick = onDeleteFlourRecipeImage,
                ) {
                    Icon(
                        painterResource(R.drawable.ic_delete),
                        contentDescription = stringResource(R.string.description_delete),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RegisterFlourRecipeImageContentPreview(
    @PreviewParameter(RegisterFlourRecipeImageContentPreviewPPP::class)
    param: RegisterFlourRecipeImageContentPreviewPPP.Param
) {
    FlourRecipeTheme {
        Surface {
            RegisterFlourRecipeImageContent(
                flourRecipeImage = param.bitmap,
                onSelectFlourRecipeImage = {},
                onDeleteFlourRecipeImage = {},
                onOpenCamera = {},
            )
        }
    }
}

private class RegisterFlourRecipeImageContentPreviewPPP :
    CollectionPreviewParameterProvider<RegisterFlourRecipeImageContentPreviewPPP.Param>(
    listOf(
        Param(
            bitmap = null
        ),
        Param(
            Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888).apply {
                    Canvas(this).drawColor(Color.RED)
                }
        )
    )
) {
    data class Param(
        val bitmap: Bitmap?
    )
}
