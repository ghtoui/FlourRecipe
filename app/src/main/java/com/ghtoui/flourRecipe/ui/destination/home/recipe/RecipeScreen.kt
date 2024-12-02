package com.ghtoui.flourRecipe.ui.destination.home.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.ui.components.FlourTopAppBar
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import com.ghtoui.flourRecipe.ui.destination.home.recipe.components.IngredientContent
import com.ghtoui.flourRecipe.ui.destination.home.recipe.components.ProcessContent
import com.ghtoui.flourRecipe.ui.destination.home.recipe.components.RecipeImage
import com.ghtoui.flourRecipe.ui.destination.home.recipe.components.ReferenceContent
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * レシピ画面
 */
@Composable
internal fun RecipeScreen(
    mainNavController: NavHostController = LocalMainNavController.current,
) {
    RecipeScreen(
        modifier = Modifier,
        recipe = getDummyRecipes().first(),
        backAble = true,
        onBackClick = mainNavController::popBackStack,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RecipeScreen(
    recipe: FlourRecipe,
    backAble: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier,
        topBar = {
            FlourTopAppBar(
                title = stringResource(id = R.string.recipe_app_top_bar_title),
                backAble = backAble,
                scrollBehavior = scrollBehavior,
                onBackClick = onBackClick,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(
                    top = innerPadding.calculateTopPadding(),
                )
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
        ) {
            RecipeImage(
                modifier = Modifier.fillMaxWidth(),
                imagePath = recipe.imagePath,
                recipeName = recipe.name
            )
            Spacer(modifier = Modifier.height(24.dp))
            IngredientContent(
                modifier = Modifier.fillMaxWidth(),
                recipeIngredients = recipe.recipeDetail.ingredients,
                servings = 10,
            )
            Spacer(modifier = Modifier.height(24.dp))
            ProcessContent(
                modifier = Modifier.fillMaxWidth(),
                recipeProcess = recipe.recipeDetail.recipeProcess,
            )
            if (recipe.recipeDetail.references.isNotEmpty()) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )
                ReferenceContent(
                    references = recipe.recipeDetail.references,
                    onReferenceURLClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecipeScreenPreview() {
    val dummyRecipe = getDummyRecipes().first()
    FlourRecipeTheme {
        Surface {
            RecipeScreen(
                modifier = Modifier,
                recipe = dummyRecipe,
                backAble = true,
                onBackClick = {},
            )
        }
    }
}
