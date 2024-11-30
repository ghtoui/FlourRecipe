package com.ghtoui.flourRecipe.model.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ghtoui.flourRecipe.R

/**
 * ボトムバーに表示するアイコン
 *
 * @property label ラベルID
 * @property selectedIcon 選択された時のアイコン
 * @property icon 選択されていない時のアイコン
 */
internal enum class BottomBarItem(
    @StringRes val label: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val icon: Int,
) {
    /**
     * ホーム
     */
    Home(
        label = R.string.bottom_home_bar_label,
        selectedIcon = R.drawable.ic_home_select,
        icon = R.drawable.ic_home,
    ),

    /**
     * 設定
     */
    Settings(
        label = R.string.bottom_settings_bar_label,
        selectedIcon = R.drawable.ic_settings_select,
        icon = R.drawable.ic_settings,
    ),
}
