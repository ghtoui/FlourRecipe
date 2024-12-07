package com.ghtoui.core.datas.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ghtoui.core.datas.model.recipe.BaseIngredient
import com.ghtoui.core.datas.model.recipe.FlourRecipe
import com.ghtoui.core.datas.model.recipe.RecipeDetail
import com.ghtoui.core.datas.model.recipe.RecipeIngredient
import com.ghtoui.core.datas.model.recipe.RecipeProcess
import com.ghtoui.core.datas.model.recipe.Reference
import com.ghtoui.core.datas.room.dao.FlourRecipeDao

@Database(entities = [
    FlourRecipe::class,
    RecipeDetail::class,
    RecipeIngredient::class,
    BaseIngredient::class,
    RecipeProcess::class,
    Reference::class,
], version = 1)
internal abstract class FlourRecipeDatabase : RoomDatabase() {
    abstract fun flourRecipeDao(): FlourRecipeDao
}
