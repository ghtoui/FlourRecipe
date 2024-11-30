package com.ghtoui.flourRecipe.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController
import com.ghtoui.flourRecipe.model.navigation.BottomBarItem
import com.ghtoui.flourRecipe.ui.components.FlourBottomBar
import com.ghtoui.flourRecipe.ui.destination.home.navigateToHome
import com.ghtoui.flourRecipe.ui.destination.settings.navigateToSettings

/**
 * メイン画面
 */
@Composable
internal fun MainScreen(
    mainNavController: NavHostController = LocalMainNavController.current,
) {
    Scaffold(
        bottomBar = {
            FlourBottomBar(
                selectedItem = BottomBarItem.Home,
                onHomeClick = mainNavController::navigateToHome,
                onSettingsClick = mainNavController::navigateToSettings,
            )
        },
    ) { innerPadding ->
        MainNavHost(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
    }
}
