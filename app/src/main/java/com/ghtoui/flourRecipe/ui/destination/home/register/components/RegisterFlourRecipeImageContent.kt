package com.ghtoui.flourRecipe.ui.destination.home.register.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun RegisterFlourRecipeImageContent(
    flourRecipeImage: ImageBitmap?,
    onSelectFlourRecipeImage: (Uri) -> Unit,
    onDeleteImage: () -> Unit,
    onClickTakePicture: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        RegisterInputTitle(
            title = stringResource(R.string.register_recipe_input_image_title)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            if (flourRecipeImage == null) {
                RegisterImageButtons(
                    onSelectFlourRecipeImage = onSelectFlourRecipeImage,
                    onClickTakePicture = onClickTakePicture,
                )
            } else {
                Image(
                    bitmap = flourRecipeImage,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = onDeleteImage
                ) {
                    Icon(
                        painterResource(R.drawable.ic_delete),
                        contentDescription = stringResource(R.string.description_delete)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RegisterFlourRecipeImageContentPreview() {
    FlourRecipeTheme {
        Surface {
            RegisterFlourRecipeImageContent(
                flourRecipeImage = null,
                onSelectFlourRecipeImage = {},
                onDeleteImage = {},
                onClickTakePicture = {},
            )
        }
    }
}
