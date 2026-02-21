package com.esaudiaz.numeromagico.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudiaz.numeromagico.presentation.domain.repository.GameRepository
import com.esaudiaz.numeromagico.presentation.domain.usecase.MakeGuessUseCase
import com.esaudiaz.numeromagico.presentation.model.Proximity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: GameRepository,
    private val makeGuessUseCase: MakeGuessUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        observeGameState()
    }

    private fun observeGameState() {
        viewModelScope.launch {
            gameRepository.gameState.collect { gameState ->
                _uiState.update {
                    it.copy(
                        livesRemaining = gameState.livesRemaining,
                        attempts = gameState.attempts,
                        isGameOver = gameState.isGameOver,
                        hasWon = gameState.hasWon
                    )
                }
            }
        }
    }

    fun handleIntent(intent: GameIntent) {
        when (intent) {
            is GameIntent.MakeGuess -> makeGuess(intent.number)
            is GameIntent.ResetGame -> resetGame()
        }
    }

    fun updateGuess(guess: String) {
        _uiState.update { it.copy(currentGuess = guess, errorMessage = null) }
    }

    private fun makeGuess(number: Int) {
        if (number < 1 || number > 100) {
            _uiState.update { it.copy(errorMessage = "Ingresa un número entre 1 y 100") }
            return
        }

        val currentGameState = gameRepository.gameState.value
        if (currentGameState.isGameOver) return

        val attemptResult = makeGuessUseCase.execute(currentGameState.magicNumber, number)

        val newAttempts = currentGameState.attempts + attemptResult
        val hasWon = attemptResult.proximity == Proximity.EXACTO
        val newLives = if (hasWon) currentGameState.livesRemaining else currentGameState.livesRemaining - 1
        val isGameOver = hasWon || newLives <= 0

        gameRepository.updateGameState(
            currentGameState.copy(
                attempts = newAttempts,
                livesRemaining = newLives,
                isGameOver = isGameOver,
                hasWon = hasWon
            )
        )

        _uiState.update { it.copy(currentGuess = "") }
    }

    private fun resetGame() {
        gameRepository.resetGame()
        _uiState.update {
            it.copy(
                currentGuess = "",
                errorMessage = null
            )
        }
    }
}