package com.esaudiaz.numeromagico.presentation.model

data class GameState(
    val magicNumber: Int,
    val livesRemaining: Int,
    val attempts: List<AttemptResult>,
    val isGameOver: Boolean,
    val hasWon: Boolean
) {
    companion object {
        const val MAX_LIVES = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 100

        fun initial(): GameState {
            return GameState(
                magicNumber = (MIN_NUMBER..MAX_NUMBER).random(),
                livesRemaining = MAX_LIVES,
                attempts = emptyList(),
                isGameOver = false,
                hasWon = false
            )
        }
    }
}