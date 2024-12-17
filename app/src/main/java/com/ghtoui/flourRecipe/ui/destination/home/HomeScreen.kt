package com.ghtoui.flourRecipe.ui.destination.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.ui.components.FlourTopAppBar
import com.ghtoui.flourRecipe.ui.destination.home.components.RecipeListItem
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import com.ghtoui.flourRecipe.ui.destination.home.recipe.navigateToRecipe
import com.ghtoui.flourRecipe.ui.destination.home.register.navigateToRegisterRecipe
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * ホーム画面
 */
@Composable
internal fun HomeScreen(
    mainNavController: NavHostController = LocalMainNavController.current,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        modifier = Modifier,
        recipes = state.flourRecipes,
        onRecipeClick = {
            mainNavController.navigateToRecipe(recipeId = it.id)
        },
        backAble = false,
        onAddClick = mainNavController::navigateToRegisterRecipe,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    recipes: List<FlourRecipe>,
    backAble: Boolean,
    onRecipeClick: (FlourRecipe) -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    val visibleAddButton = !lazyListState.isScrollInProgress
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier,
        topBar = {
            FlourTopAppBar(
                title = stringResource(id = R.string.home_app_top_bar_title),
                backAble = backAble,
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding()),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                state = lazyListState,
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(recipes, key = { it.id }) { recipe ->
                    RecipeListItem(
                        modifier = Modifier.fillMaxWidth(),
                        recipe = recipe,
                        onRecipeClick = { onRecipeClick(recipe) },
                    )
                }
            }
            if (visibleAddButton) {
                FloatingActionButton(
                    modifier = Modifier
                        .padding(24.dp)
                        .align(Alignment.BottomEnd),
                    onClick = { onAddClick() },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = stringResource(id = R.string.description_add_recipe),
                    )
                }
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
                onAddClick = {},
            )
        }
    }
}
