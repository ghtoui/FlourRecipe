package com.ghtoui.flourRecipe.ui.destination.home.register.components

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun RegisterImageButtons(
    onSelectFlourRecipeImage: (Uri) -> Unit,
    onClickTakePicture: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        IconButton(
            onClick = onClickTakePicture
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = stringResource(R.string.description_take_picture_recipe_image)
            )
        }
        AddFlourRecipeImage(
            onSelectFlourRecipeImage = onSelectFlourRecipeImage
        )
    }
}

@Composable
private fun AddFlourRecipeImage(
    onSelectFlourRecipeImage: (Uri) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val pickMedia = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let {
                val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
                context.contentResolver.takePersistableUriPermission(uri, flag)

                onSelectFlourRecipeImage(uri)
            }
        }
    )

    IconButton(
        modifier = modifier,
        onClick = {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_image),
            contentDescription = stringResource(R.string.description_add_recipe_image)
        )
    }
}

@Preview
@Composable
private fun RegisterImageButtonsPreview() {
    FlourRecipeTheme {
        Surface {
            RegisterImageButtons(
                onSelectFlourRecipeImage = {},
                onClickTakePicture = {},
            )
        }
    }
}
