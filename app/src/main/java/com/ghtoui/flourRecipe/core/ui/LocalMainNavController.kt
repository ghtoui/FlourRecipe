package com.ghtoui.flourRecipe.core.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalMainNavController =
    compositionLocalOf<NavHostController> {
        error("LocalMainNavControllerが無いよ")
    }
