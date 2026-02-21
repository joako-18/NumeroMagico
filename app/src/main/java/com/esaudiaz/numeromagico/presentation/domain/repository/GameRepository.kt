package com.esaudiaz.numeromagico.presentation.domain.repository

import com.esaudiaz.numeromagico.presentation.model.GameState
import kotlinx.coroutines.flow.StateFlow

interface GameRepository {
    val gameState: StateFlow<GameState>
    fun updateGameState(newState: GameState)
    fun resetGame()
}