package pl.example.calculator.appUI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import pl.example.calculator.CalculatorViewModel
import pl.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    private val mainVm by viewModels<CalculatorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = MaterialTheme.colorScheme.onBackground.toArgb()
            window.navigationBarColor = window.statusBarColor
            CalculatorTheme {
                CalculatorScreen(mainVm)
            }
        }
    }
}
