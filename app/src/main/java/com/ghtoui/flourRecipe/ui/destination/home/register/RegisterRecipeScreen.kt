package com.ghtoui.flourRecipe.ui.destination.home.register

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.ghtoui.domain.model.recipe.FlourRecipe
import com.ghtoui.flourRecipe.R
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.ui.components.FlourBottomBar
import com.ghtoui.flourRecipe.ui.components.FlourTopAppBar
import com.ghtoui.flourRecipe.ui.destination.camera.navigateToCameraScreen
import com.ghtoui.flourRecipe.ui.destination.home.preview.getDummyRecipes
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterFlourRecipeImageContent
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterInputFlourContent
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterInputIngredientContent
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterInputProcessContent
import com.ghtoui.flourRecipe.ui.destination.home.register.components.RegisterInputReferenceContent
import com.ghtoui.flourRecipe.ui.destination.home.register.model.RegisterRecipeState
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme
import java.net.URL

/**
 * レシピ登録画面
 */
@Composable
internal fun RegisterRecipeScreen(
    mainNavController: NavHostController = LocalMainNavController.current,
    viewModel: RegisterRecipeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    RegisterRecipeScreen(
        state = state,
        recipe = getDummyRecipes().first(),
        backAble = true,
        onBackClick = mainNavController::navigateUp,
        onFlourAddClick = {},
        onIngredientAddClick = {},
        onReferenceAddClick = {},
        onRegisterClick = {},
        onReferenceURLClick = {},
        onAddInputProcessClick = {},
        onSelectFlourRecipeImage = viewModel::onSelectFlourRecipeImage,
        onDeleteFlourRecipeImage = viewModel::onDeleteSelectFlourRecipeImage,
        onOpenCamera = mainNavController::navigateToCameraScreen,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterRecipeScreen(
    state: RegisterRecipeState,
    recipe: FlourRecipe,
    backAble: Boolean,
    onBackClick: () -> Unit,
    onFlourAddClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onIngredientAddClick: () -> Unit,
    onReferenceAddClick: () -> Unit,
    onAddInputProcessClick: () -> Unit,
    onReferenceURLClick: (URL) -> Unit,
    onDeleteFlourRecipeImage: () -> Unit,
    onSelectFlourRecipeImage: (Uri) -> Unit,
    onOpenCamera: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier,
        topBar = {
            FlourTopAppBar(
                title = stringResource(R.string.register_recipe_app_top_bar_title),
                backAble = backAble,
                onBackClick = onBackClick,
            )
        },
        bottomBar = {
            FlourBottomBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding(),
                ),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                RegisterFlourRecipeImageContent(
                    modifier = Modifier.fillMaxWidth(),
                    flourRecipeImage = state.recipeImage,
                    onDeleteFlourRecipeImage = onDeleteFlourRecipeImage,
                    onSelectFlourRecipeImage = onSelectFlourRecipeImage,
                    onOpenCamera = onOpenCamera,
                )
                RegisterInputFlourContent(
                    modifier = Modifier.fillMaxWidth(),
                    onFlourAddClick = onFlourAddClick,
                    ingredients = recipe.recipeDetail?.ingredients ?: emptyList(),
                )
                RegisterInputIngredientContent(
                    modifier = Modifier.fillMaxWidth(),
                    onIngredientAddClick = onIngredientAddClick,
                    ingredients = recipe.recipeDetail?.ingredients ?: emptyList(),
                )
                RegisterInputProcessContent(
                    modifier = Modifier.fillMaxWidth(),
                    process = recipe.recipeDetail?.recipeProcess ?: emptyList(),
                    onAddInputProcessClick = onAddInputProcessClick,
                )
                RegisterInputReferenceContent(
                    modifier = Modifier.fillMaxWidth(),
                    references = recipe.recipeDetail?.references ?: emptyList(),
                    onReferenceAddClick = onReferenceAddClick,
                    onReferenceURLClick = onReferenceURLClick,
                )
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.primary,
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 4.dp),
                onClick = onRegisterClick,
            ) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                    ),
                    text = stringResource(R.string.register_label),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}

@Preview(heightDp = 1500)
@Composable
private fun RegisterRecipeScreenPreview() {
    FlourRecipeTheme {
        Surface {
            RegisterRecipeScreen(
                state = RegisterRecipeState.initial(),
                modifier = Modifier,
                recipe = getDummyRecipes().first(),
                backAble = true,
                onBackClick = {},
                onFlourAddClick = {},
                onIngredientAddClick = {},
                onReferenceAddClick = {},
                onRegisterClick = {},
                onReferenceURLClick = {},
                onAddInputProcessClick = {},
                onSelectFlourRecipeImage = {},
                onDeleteFlourRecipeImage = {},
                onOpenCamera = {},
            )
        }
    }
}
