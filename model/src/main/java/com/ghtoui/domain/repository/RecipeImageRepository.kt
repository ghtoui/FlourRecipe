package com.ghtoui.domain.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.StateFlow

/**
 * レシピ写真のレポジトリ
 */
interface RecipeImageRepository {
    /**
     * レシピの写真
     */
    val recipeImage: StateFlow<Bitmap?>

    /**
     * 写真撮影
     *
     * @param picture 撮影した写真
     */
    fun takeRecipePicture(picture: Bitmap)

    /**
     * 写真を削除する
     */
    fun deleteRecipePicture()
}
