package com.ghtoui.domain.repository

import com.ghtoui.domain.model.recipe.FlourRecipe
import kotlinx.coroutines.flow.Flow

/**
 * レシピのリポジトリ
 */
interface FlourRecipeRepository {
    /**
     * レシピ一覧取得
     *
     * @return [Flow]<[List]<[FlourRecipe]>>
     */
    suspend fun getRecipeList(): Flow<List<FlourRecipe>>

    /**
     * レシピ保存
     */
    suspend fun saveRecipe(flourRecipe: FlourRecipe): Result<Unit>
}
