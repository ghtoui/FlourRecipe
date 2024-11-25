package com.ghtoui.flourRecipe.core.ui

import android.util.Log
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController

val LocalMainNavController = compositionLocalOf<NavHostController> {
    error("LocalMainNavControllerが無いよ")
}
