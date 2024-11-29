package com.ghtoui.flourRecipe.ui.destination.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.ui.component.FlourTopAppBar
import com.ghtoui.flourRecipe.ui.destination.home.components.RecipeListItem
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * ホーム画面
 */
@Composable
fun HomeScreen(mainNavHostController: NavHostController = LocalMainNavController.current) {
    HomeScreen(
        modifier = Modifier,
        recipes = getDummyRecipes(count = 20),
        onRecipeClick = {},
        backAble = false,
    )
}

@Composable
private fun HomeScreen(
    recipes: List<FlourRecipe>,
    backAble: Boolean,
    onRecipeClick: (FlourRecipe) -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    Scaffold(
        modifier = modifier,
        topBar = {
            FlourTopAppBar(
                title = stringResource(id = R.string.home_app_top_bar_title),
                backAble = backAble,
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            state = lazyListState,
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recipes, key = { it.id }) { recipe ->
                RecipeListItem(
                    modifier = Modifier.fillMaxWidth(),
                    recipe = recipe,
                    onRecipeClick = { onRecipeClick(recipe) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val dummyFlourRecipe = getDummyRecipes()
    FlourRecipeTheme {
        Surface {
            HomeScreen(
                recipes = dummyFlourRecipe,
                onRecipeClick = {},
                backAble = false,
            )
        }
    }
}
