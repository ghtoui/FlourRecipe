package com.ghtoui.flourRecipe.ui.destination.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController

/**
 * ホーム画面
 */
@Composable
fun HomeScreen(
    mainNavHostController: NavHostController = LocalMainNavController.current
) {
    Text(text = "home")
}
