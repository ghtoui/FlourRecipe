package com.ghtoui.core.datas.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.ghtoui.core.datas.model.recipe.FlourRecipe
import com.ghtoui.core.datas.model.recipe.FlourRecipeDetailRelation
import kotlinx.coroutines.flow.Flow

@Dao
internal interface FlourRecipeDao {
    /**
     * 全てのレシピを取得する
     *
     * @return [Flow]<[List]<[FlourRecipe]>>
     */
    @Transaction
    @Query("SELECT * FROM FlourRecipe")
    fun getAllFlourRecipe(): Flow<List<FlourRecipe>>

    /**
     * idが一致するレシピとその詳細情報を取得する
     *
     * @param id ID
     * @return [Flow]<[FlourRecipeDetailRelation]>
     */
//    @Transaction
//    @Query("SELECT * FROM FlourRecipe WHERE recipeId IN (:id)")
//    fun getFlourRecipeWithDetail(id: Int): Flow<FlourRecipeDetailRelation>

    /**
     * レシピを保存
     *
     * @param flourRecipe [FlourRecipe]
     */
    @Transaction
    @Upsert
    fun insertFlourRecipe(flourRecipe: FlourRecipe)

    /**
     * レシピを削除する
     *
     * @param flourRecipe [FlourRecipe]
     */
    @Transaction
    @Delete
    fun deleteFlourRecipe(flourRecipe: FlourRecipe)
}
