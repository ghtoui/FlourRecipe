package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ghtoui.core.extensions.string.isURL
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import java.net.URL


@Composable
internal fun ReferenceItem(
    reference: String,
    modifier: Modifier = Modifier,
    onReferenceURLClick: ((URL) -> Unit)? = null,
) {
    Box(
        modifier = modifier
    ) {
        if (reference.isURL) {
            ReferenceURLItem(
                clickable = onReferenceURLClick != null,
                onReferenceURLClick = {
                    if (onReferenceURLClick != null) {
                        onReferenceURLClick(URL(reference))
                    }
                },
            )
        } else {
            ReferenceItemText(
                reference = reference
            )
        }
    }
}

@Composable
private fun ReferenceURLItem(
    onReferenceURLClick: () -> Unit,
    clickable: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .clickable(
                enabled = clickable,
                onClick = onReferenceURLClick,
            ),
    ) {
        Column(
            Modifier.width(IntrinsicSize.Max),
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_link),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.recipe_reference_web_site),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            if (clickable) {
                HorizontalDivider()
            }
        }
    }
}

@Composable
private fun ReferenceItemText(
    reference: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.padding(horizontal = 12.dp),
        text = reference,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Preview
@Composable
private fun ReferenceItemPreview(
    @PreviewParameter(ReferenceItemPreviewPPP::class) param: ReferenceItemPreviewPPP.Param
) {
    FlourRecipeTheme {
        Surface {
            ReferenceItem(
                modifier = Modifier.padding(4.dp),
                reference = param.reference,
                onReferenceURLClick = param.onReferenceURLClick
            )
        }
    }
}

private class ReferenceItemPreviewPPP :
    CollectionPreviewParameterProvider<ReferenceItemPreviewPPP.Param>(
        listOf(
            Param(
                reference = "https://example.com",
                onReferenceURLClick = null
            ),
            Param(
                reference = "https://example.com",
                onReferenceURLClick = {}
            ),
            Param(
                reference = "本",
                onReferenceURLClick = null
            ),
        )
    ) {
    data class Param(
        val reference: String,
        val onReferenceURLClick: ((URL) -> Unit)?
    )
}
