package com.ghtoui.flourRecipe.ui.destination.home.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ghtoui.domain.model.recipe.RecipeIngredient
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.ui.components.FlourTopAppBar
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyIngredients
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterInputFlourContent
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * レシピ登録画面
 */
@Composable
internal fun RegisterRecipeScreen(
    mainNavController: NavHostController = LocalMainNavController.current
) {
    RegisterRecipeScreen(
        backAble = true,
        onBackClick = mainNavController::popBackStack,
        onFlourAddClick = {},
        ingredients = getDummyIngredients(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterRecipeScreen(
    ingredients: List<RecipeIngredient>,
    backAble: Boolean,
    onBackClick: () -> Unit,
    onFlourAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier,
        topBar = {
            FlourTopAppBar(
                title = stringResource(R.string.register_recipe_app_top_bar_title),
                backAble = backAble,
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp),
        ) {
            RegisterInputFlourContent(
                modifier = Modifier.fillMaxWidth(),
                onAddClick = onFlourAddClick,
                ingredients = ingredients
            )
        }
    }
}

@Preview
@Composable
private fun RegisterRecipeScreenPreview() {
    FlourRecipeTheme {
        Surface {
            RegisterRecipeScreen(
                modifier = Modifier,
                backAble = true,
                onBackClick = {},
                onFlourAddClick = {},
                ingredients = getDummyIngredients(),
            )
        }
    }
}
