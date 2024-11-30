package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * トップバー
 *
 * @param title タイトル
 * @param backAble 戻れるボタンをつけるか
 * @param modifier [Modifier]
 * @param scrollBehavior スクロール時にトップバーを隠す
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FlourTopAppBar(
    title: String,
    backAble: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
            )
        },
        navigationIcon = {
            if (backAble) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(id = R.string.description_back_navigation),
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun FlourTopAppBarPreview(
    @PreviewParameter(FlourTopAppBarPreviewPPP::class) param: FlourTopAppBarPreviewPPP.Param,
) {
    FlourRecipeTheme {
        Surface {
            FlourTopAppBar(
                title = stringResource(id = R.string.home_app_top_bar_title),
                backAble = param.backAble,
            )
        }
    }
}

private class FlourTopAppBarPreviewPPP : CollectionPreviewParameterProvider<FlourTopAppBarPreviewPPP.Param>(
    listOf(
        Param(
            backAble = true,
        ),
        Param(
            backAble = false,
        ),
    ),
) {
    data class Param(
        val backAble: Boolean,
    )
}
