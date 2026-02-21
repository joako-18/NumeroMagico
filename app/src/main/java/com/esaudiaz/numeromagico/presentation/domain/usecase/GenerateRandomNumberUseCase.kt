package com.esaudiaz.numeromagico.presentation.domain.usecase

import javax.inject.Inject

class GenerateRandomNumberUseCase @Inject constructor() {

    fun execute(min: Int = 1, max: Int = 100): Int {
        return (min..max).random()
    }
}