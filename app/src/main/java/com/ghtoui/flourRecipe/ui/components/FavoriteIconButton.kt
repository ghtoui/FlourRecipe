package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * お気に入りアイコン
 *
 * お気に入りであれば，赤いハートアイコンを表示する
 *
 * @param isFavorite お気に入りか
 * @param modifier [Modifier]
 */
@Composable
internal fun FavoriteIconButton(
    isFavorite: Boolean,
    onFavoriteClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val iconSize = 24.dp
    Box(
        modifier = modifier
            .size(48.dp)
            .clickable(
                onClick = { onFavoriteClick(isFavorite) },
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    color = MaterialTheme.colorScheme.error,
                    radius = iconSize,
                    bounded = false
                ),
                role = Role.Button
            ),
        contentAlignment = Alignment.Center,
    ) {
        if (isFavorite) {
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(id = R.drawable.ic_favorite_select),
                contentDescription = stringResource(id = R.string.description_favorite_select),
            )
        } else {
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = stringResource(id = R.string.description_favorite_un_select),
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteIconPreview(
    @PreviewParameter(FavoriteIconPreviewPPP::class) param: FavoriteIconPreviewPPP.Param
) {
    FlourRecipeTheme {
        Surface {
            FavoriteIconButton(
                isFavorite = param.isFavorite,
                onFavoriteClick = {},
            )
        }
    }
}

private class FavoriteIconPreviewPPP :
    CollectionPreviewParameterProvider<FavoriteIconPreviewPPP.Param>(
        listOf(
            Param(false),
            Param(true),
        )
    ) {
    data class Param(
        val isFavorite: Boolean
    )
}
