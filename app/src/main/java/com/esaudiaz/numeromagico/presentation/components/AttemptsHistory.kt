package com.esaudiaz.numeromagico.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esaudiaz.numeromagico.presentation.model.AttemptResult

@Composable
fun AttemptsHistory(attempts: List<AttemptResult>) {
    if (attempts.isEmpty()) {
        Text(
            text = "No hay intentos aún",
            fontSize = 16.sp,
            color = Color.Gray
        )
    } else {
        Text(
            text = "Historial de intentos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(attempts.reversed()) { attempt ->
                AttemptCard(attempt = attempt)
            }
        }
    }
}