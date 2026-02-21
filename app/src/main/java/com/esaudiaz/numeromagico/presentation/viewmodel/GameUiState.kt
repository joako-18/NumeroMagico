package com.esaudiaz.numeromagico.presentation.viewmodel

import com.esaudiaz.numeromagico.presentation.model.AttemptResult

data class GameUiState(
    val livesRemaining: Int = 6,
    val attempts: List<AttemptResult> = emptyList(),
    val isGameOver: Boolean = false,
    val hasWon: Boolean = false,
    val currentGuess: String = "",
    val errorMessage: String? = null
)