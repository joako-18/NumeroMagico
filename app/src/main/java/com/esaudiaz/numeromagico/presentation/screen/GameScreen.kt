package com.esaudiaz.numeromagico.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.esaudiaz.numeromagico.presentation.viewmodel.GameIntent
import com.esaudiaz.numeromagico.presentation.viewmodel.GameViewModel
import com.esaudiaz.numeromagico.presentation.components.AttemptsHistory
import com.esaudiaz.numeromagico.presentation.components.GameHeader
import com.esaudiaz.numeromagico.presentation.components.GameOverSection
import com.esaudiaz.numeromagico.presentation.components.InputSection
import com.esaudiaz.numeromagico.presentation.components.LivesIndicator

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GameHeader()

            Spacer(modifier = Modifier.height(16.dp))

            LivesIndicator(livesRemaining = uiState.livesRemaining)

            Spacer(modifier = Modifier.height(24.dp))

            if (!uiState.isGameOver) {
                InputSection(
                    currentGuess = uiState.currentGuess,
                    errorMessage = uiState.errorMessage,
                    onGuessChange = { viewModel.updateGuess(it) },
                    onSubmit = {
                        uiState.currentGuess.toIntOrNull()?.let { number ->
                            viewModel.handleIntent(GameIntent.MakeGuess(number))
                        }
                    }
                )
            } else {
                GameOverSection(
                    hasWon = uiState.hasWon,
                    onReset = { viewModel.handleIntent(GameIntent.ResetGame) }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            AttemptsHistory(attempts = uiState.attempts)
        }
    }
}