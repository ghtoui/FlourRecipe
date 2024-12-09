package com.ghtoui.flourRecipe.ui.destination.home.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

@Composable
internal fun RegisterInputReferenceContent(
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        RegisterInputTitle(
            title = stringResource(R.string.register_recipe_input_reference_title)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}



@Preview
@Composable
private fun RegisterInputReferenceContentPreview() {
    FlourRecipeTheme {
        Surface {
            RegisterInputReferenceContent(

            )
        }
    }
}
