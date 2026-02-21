package com.esaudiaz.numeromagico.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GameHeader() {
    Text(
        text = "🎯 Número Mágico",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}