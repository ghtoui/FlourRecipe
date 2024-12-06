package com.ghtoui.core.datas.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        FlourRecipeDatabase::class.java,
        "flour_recipe_database"
        ).build()

    @Singleton
    @Provides
    fun provideFlourRecipeDao(
        db: FlourRecipeDatabase
    ) = db.flourRecipeDao()
}
