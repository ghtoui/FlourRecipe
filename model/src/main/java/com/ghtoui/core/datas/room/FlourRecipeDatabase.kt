package com.ghtoui.core.datas.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ghtoui.core.datas.room.dao.FlourRecipeDao
import com.ghtoui.domain.model.recipe.FlourRecipe

@Database(entities = [FlourRecipe::class], version = 1)
abstract class FlourRecipeDatabase : RoomDatabase() {
    abstract fun flourRecipeDao(): FlourRecipeDao
}
