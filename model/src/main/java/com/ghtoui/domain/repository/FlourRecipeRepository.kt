package com.ghtoui.domain.repository

import com.ghtoui.flourRecipe.model.recipe.FlourRecipe

/**
 * レシピのリポジトリ
 */
interface FlourRecipeRepository {
    /**
     * レシピ一覧取得
     *
     * @return [Result]<[List]<[FlourRecipe]>>
     */
    suspend fun getRecipeList(): Result<List<FlourRecipe>>

    /**
     * レシピ保存
     */
    suspend fun saveRecipe(): Result<Unit>
}
