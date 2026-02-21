package com.esaudiaz.numeromagico.presentation.model

data class AttemptResult(
    val number: Int,
    val proximity: Proximity,
    val difference: Int
)