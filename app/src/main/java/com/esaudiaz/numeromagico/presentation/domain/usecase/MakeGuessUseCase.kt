package com.esaudiaz.numeromagico.presentation.domain.usecase

import com.esaudiaz.numeromagico.presentation.model.AttemptResult
import com.esaudiaz.numeromagico.presentation.model.Proximity
import javax.inject.Inject
import kotlin.math.abs

class MakeGuessUseCase @Inject constructor() {

    fun execute(magicNumber: Int, guess: Int): AttemptResult {
        val difference = abs(magicNumber - guess)
        val proximity = calculateProximity(difference)

        return AttemptResult(
            number = guess,
            proximity = proximity,
            difference = difference
        )
    }

    private fun calculateProximity(difference: Int): Proximity {
        return when (difference) {
            0 -> Proximity.EXACTO
            in 1..5 -> Proximity.MUY_CERCA
            in 6..10 -> Proximity.CERCA
            in 11..20 -> Proximity.MEDIO
            in 21..35 -> Proximity.LEJOS
            else -> Proximity.MUY_LEJOS
        }
    }
}