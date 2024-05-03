package pl.example.calculator.appUI

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.example.calculator.CalculatorViewModel

@Composable
fun CalculatorButtons(
    symbol: String,
    viewModel: CalculatorViewModel,
    onClick: () -> Unit,
) {
    ElevatedButton(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Green
        ), modifier = Modifier
            .border(
                width = 3.dp,
                brush = Brush.horizontalGradient(listOf(Color.Green, Color.Green)),
                shape = CircleShape
            ).height(100.dp).width(100.dp)
    ) {
        Text(text = symbol, fontSize = 50.sp, color = viewModel.fontColor)
    }
}

@Preview
@Composable
private fun CalculatorButtonsPreview() {
    CalculatorButtons(symbol = "0", viewModel = CalculatorViewModel()) {
        
    }
}