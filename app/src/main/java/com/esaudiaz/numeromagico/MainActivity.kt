package com.esaudiaz.numeromagico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.esaudiaz.numeromagico.presentation.screen.GameScreen
import com.esaudiaz.numeromagico.ui.theme.NumeroMagicoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumeroMagicoTheme {
                GameScreen()
            }
        }
    }
}