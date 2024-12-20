package com.ghtoui.domain

import com.ghtoui.domain.impl.FlourRecipeRepositoryImpl
import com.ghtoui.domain.impl.RecipeImageRepositoryImpl
import com.ghtoui.domain.repository.FlourRecipeRepository
import com.ghtoui.domain.repository.RecipeImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideFlourRecipeRepository(impl: FlourRecipeRepositoryImpl): FlourRecipeRepository

    @Binds
    @Singleton
    abstract fun provideRecipeImageRepository(
        impl: RecipeImageRepositoryImpl
    ): RecipeImageRepository
}
