package com.ghtoui.flourRecipe.ui.destination.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ghtoui.flourRecipe.core.extensions.zoneddatetime.formatDateTime
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.ui.components.FlourAsyncImage
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * レシピのリストアイテム
 */
@Composable
fun RecipeListItem(
    recipe: FlourRecipe,
    onRecipeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable {
                onRecipeClick()
            }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FlourAsyncImage(
            modifier = Modifier
                .height(48.dp)
                .aspectRatio(1f),
            path = recipe.path ?: "",
            contentDescription = null,
        )
        Spacer(
            modifier = Modifier
                .width(16.dp),
        )
        RecipeItemInfo(
            recipe = recipe,
        )
    }
}

@Composable
private fun RecipeItemInfo(
    recipe: FlourRecipe,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Column {
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.labelLarge,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = recipe.lastCreateDate.formatDateTime(),
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

@Preview
@Composable
private fun HomeListItemPreview() {
    val dummyRecipe = getDummyRecipes().first()
    FlourRecipeTheme {
        Surface {
            RecipeListItem(
                dummyRecipe,
                onRecipeClick = {},
            )
        }
    }
}
