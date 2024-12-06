package com.ghtoui.domain

import com.ghtoui.domain.impl.FlourRecipeRepositoryImpl
import com.ghtoui.domain.repository.FlourRecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideFlourRecipeRepository(impl: FlourRecipeRepositoryImpl): FlourRecipeRepository
}
