package com.esaudiaz.numeromagico.presentation.data.repository

import com.esaudiaz.numeromagico.presentation.domain.repository.GameRepository
import com.esaudiaz.numeromagico.presentation.domain.usecase.GenerateRandomNumberUseCase
import com.esaudiaz.numeromagico.presentation.model.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val generateRandomNumberUseCase: GenerateRandomNumberUseCase
) : GameRepository {

    private val _gameState = MutableStateFlow(createInitialState())
    override val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    override fun updateGameState(newState: GameState) {
        _gameState.value = newState
    }

    override fun resetGame() {
        _gameState.value = createInitialState()
    }

    private fun createInitialState(): GameState {
        return GameState(
            magicNumber = generateRandomNumberUseCase.execute(),
            livesRemaining = GameState.MAX_LIVES,
            attempts = emptyList(),
            isGameOver = false,
            hasWon = false
        )
    }
}