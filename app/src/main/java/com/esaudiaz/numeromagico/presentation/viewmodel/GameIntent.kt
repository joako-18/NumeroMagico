package com.esaudiaz.numeromagico.presentation.viewmodel

sealed class GameIntent {
    data class MakeGuess(val number: Int) : GameIntent()
    object ResetGame : GameIntent()
}