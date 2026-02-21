package com.esaudiaz.numeromagico.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esaudiaz.numeromagico.presentation.model.AttemptResult

@Composable
fun AttemptCard(attempt: AttemptResult) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = attempt.proximity.color.copy(alpha = 0.2f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Número: ${attempt.number}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = attempt.proximity.message,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = attempt.proximity.color
                )
            }
        }
    }
}