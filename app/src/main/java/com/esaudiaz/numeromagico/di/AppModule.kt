package com.esaudiaz.numeromagico.di

import com.esaudiaz.numeromagico.presentation.data.repository.GameRepositoryImpl
import com.esaudiaz.numeromagico.presentation.domain.repository.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindGameRepository(
        gameRepositoryImpl: GameRepositoryImpl
    ): GameRepository
}