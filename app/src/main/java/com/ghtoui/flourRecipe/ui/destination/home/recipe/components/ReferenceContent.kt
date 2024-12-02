package com.ghtoui.flourRecipe.ui.destination.home.recipe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.core.extensions.string.isURL
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.components.BiColorHorizontalDivider
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import java.net.URL

/**
 * 参照したもののコンテンツ
 *
 * @param references 参照リスト
 * @param onReferenceURLClick URLのクリック
 * @param modifier [Modifier]
 */
@Composable
internal fun ReferenceContent(
    references: List<String>,
    onReferenceURLClick: (URL) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.recipe_reference),
            style = MaterialTheme.typography.titleLarge,
        )
        BiColorHorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            references.forEach { reference ->
                if (reference.isURL) {
                    ReferenceURLItem(
                        onReferenceURLClick = {
                            onReferenceURLClick(
                                URL(reference)
                            )
                        }
                    )
                } else {
                    ReferenceItem(
                        reference = reference,
                    )
                }
            }
        }
    }
}

@Composable
private fun ReferenceURLItem(
    onReferenceURLClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .clickable {
                onReferenceURLClick()
            }
    ) {
        Column(
            Modifier.width(IntrinsicSize.Max)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_link),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.recipe_reference_web_site),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            HorizontalDivider()
        }
    }
}

@Composable
private fun ReferenceItem(
    reference: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = reference,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Preview
@Composable
private fun ReferenceContentPreview() {
    FlourRecipeTheme {
        Surface {
            ReferenceContent(
                modifier = Modifier,
                references = listOf(
                    "https://example.com",
                    "パン作りの本 2ページ目",
                    "パン作りの本 2ページ目",
                    "パン作りの本 2ページ目",
                ),
                onReferenceURLClick = {},
            )
        }
    }
}
