package com.ghtoui.flourRecipe.ui.destination.home

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.ui.destination.settings.navigateToSettings
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * ホーム画面
 */
@Composable
fun HomeScreen(mainNavHostController: NavHostController = LocalMainNavController.current) {
    HomeScreen(
        modifier = Modifier,
        onClickButton = mainNavHostController::navigateToSettings,
    )
}

@Composable
private fun HomeScreen(
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FlourRecipeTheme {
        Surface {
            HomeScreen(
                onClickButton = {},
            )
        }
    }
}
