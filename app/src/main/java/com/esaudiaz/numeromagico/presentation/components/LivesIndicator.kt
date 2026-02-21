package com.esaudiaz.numeromagico.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LivesIndicator(livesRemaining: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Vidas: ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        repeat(6) { index ->
            Text(
                text = if (index < livesRemaining) "❤️" else "🖤",
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }
    }
}