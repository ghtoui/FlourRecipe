package com.ghtoui.flourRecipe.ui.destination.settings

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ghtoui.flourRecipe.core.ui.LocalMainNavController

@Composable
fun SettingsScreen(
    mainNavHostController: NavHostController = LocalMainNavController.current
) {
    Button(
        modifier = Modifier
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()),
        onClick = mainNavHostController::popBackStack
    ) {
        Text(text = "back")
    }
}
