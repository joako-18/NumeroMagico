package com.esaudiaz.numeromagico.presentation.model

import androidx.compose.ui.graphics.Color

enum class Proximity(val message: String, val color: Color) {
    EXACTO("¡EXACTO!", Color.Green),
    MUY_CERCA("Muy cerca", Color(0xFFFF6B6B)),
    CERCA("Cerca", Color(0xFFFFA500)),
    MEDIO("Medio", Color(0xFFFFD700)),
    LEJOS("Lejos", Color(0xFF87CEEB)),
    MUY_LEJOS("Muy lejos", Color(0xFF4169E1))
}