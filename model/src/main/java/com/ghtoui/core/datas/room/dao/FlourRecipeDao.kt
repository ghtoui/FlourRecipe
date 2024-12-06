package com.ghtoui.core.datas.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ghtoui.domain.model.recipe.FlourRecipe
import kotlinx.coroutines.flow.Flow

@Dao
interface FlourRecipeDao {
    /**
     * 全てのレシピを取得する
     *
     * @return [Flow]<[List]<[FlourRecipe]>>
     */
    @Query("SELECT * FROM flourRecipe")
    fun getAllFlourRecipe(): Flow<List<FlourRecipe>>

    /**
     * idが一致するレシピを取得する
     *
     * @param id ID
     * @return [Flow]<[FlourRecipe]>
     */
    @Query("SELECT * FROM FlourRecipe WHERE id IN (:id)")
    fun getFlourRecipe(id: Int): Flow<FlourRecipe>

    /**
     * レシピを保存
     *
     * @param flourRecipe [FlourRecipe]
     */
    @Upsert
    fun insertFlourRecipe(flourRecipe: FlourRecipe)

    /**
     * レシピを削除する
     *
     * @param flourRecipe [FlourRecipe]
     */
    @Delete
    fun deleteFlourRecipe(flourRecipe: FlourRecipe)
}
