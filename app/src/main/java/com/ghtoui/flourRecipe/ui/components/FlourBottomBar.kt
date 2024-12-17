package com.ghtoui.flourRecipe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.navigation.BottomBarItem
import com.ghtoui.flourRecipe.ui.destination.home.navigateToHome
import com.ghtoui.flourRecipe.ui.destination.settings.navigateToSettings
import com.ghtoui.flourRecipe.ui.theme.FlourRecipeTheme

/**
 * ボトムバー
 *
 * @param mainNavController [NavHostController]
 * @param onHomeClick ホームをタップした時
 * @param onSettingsClick 設定をタップした時
 * @param modifier [Modifier]
 */
@Composable
internal fun FlourBottomBar(
    mainNavController: NavHostController = LocalMainNavController.current,
    onHomeClick: () -> Unit = mainNavController::navigateToHome,
    onSettingsClick: () -> Unit = mainNavController::navigateToSettings,
    modifier: Modifier = Modifier,
) {
    val currentBackStack by mainNavController.currentBackStackEntryAsState()
    // TODO: 選択されているものをロジックで実装する
    val selectedItem = BottomBarItem.Home

    BottomAppBar(
        modifier = modifier,
    ) {
        BottomBarItem.entries.forEach { bottomBarItem ->
            NavigationBarItem(
                // 選択済みのインジケーターは表示しない
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIndicatorColor = Color.Transparent,
                ),
                selected = selectedItem == bottomBarItem,
                onClick = when (bottomBarItem) {
                    BottomBarItem.Home -> onHomeClick
                    BottomBarItem.Settings -> onSettingsClick
                },
                icon = {
                    Image(
                        painter = painterResource(
                            id = if (selectedItem == bottomBarItem) {
                                bottomBarItem.selectedIcon
                            } else {
                                bottomBarItem.icon
                            },
                        ),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = bottomBarItem.label),
                        style = MaterialTheme.typography.labelSmall,
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun FlourBottomNavigationPreview(
    @PreviewParameter(FlourBottomNavigationPreviewPPP::class) param: FlourBottomNavigationPreviewPPP.Param,
) {
    FlourRecipeTheme {
        Surface {
            FlourBottomBar(
                modifier = Modifier,
                onSettingsClick = {},
                onHomeClick = {},
            )
        }
    }
}

private class FlourBottomNavigationPreviewPPP :
    CollectionPreviewParameterProvider<FlourBottomNavigationPreviewPPP.Param>(
        listOf(
            Param(
                BottomBarItem.Home,
            ),
            Param(
                BottomBarItem.Settings,
            ),
        ),
    ) {
    data class Param(
        val selectedItem: BottomBarItem,
    )
}
