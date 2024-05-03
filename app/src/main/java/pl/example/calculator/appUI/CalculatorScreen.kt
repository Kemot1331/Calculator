package pl.example.calculator.appUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.example.calculator.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(viewModel.backgroundColor),
        contentAlignment = Alignment.TopCenter
    ){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.End) {
            Text(text = viewModel.expression,
                color = viewModel.fontColor,
                fontSize = 22.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(16.dp),
                maxLines = 3
            )

            Text(text = viewModel.result,
                color = viewModel.fontColor,
                fontSize = 44.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(16.dp)
                )
            Spacer(modifier = Modifier.height(16.dp))
            Divider()

            Spacer(modifier = Modifier.height(50.dp))
            //Buttons


            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
                ){
                CalculatorButtons(symbol = "C", viewModel = CalculatorViewModel()) {
                viewModel.expression = ""
                viewModel.result = ""
                }


                CalculatorButtons(symbol = "/", viewModel = CalculatorViewModel()) {
                    viewModel.addSymbol("/")
                }


                CalculatorButtons(symbol = "x", viewModel = CalculatorViewModel()) {
                    viewModel.addSymbol("x")
                }


                CalculatorButtons(symbol = "⌫", viewModel = CalculatorViewModel()) {
                   viewModel.expression = viewModel.delCharacter(expression = viewModel.expression)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                CalculatorButtons(symbol = "7", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 7
                }


                CalculatorButtons(symbol = "8", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 8
                }


                CalculatorButtons(symbol = "9", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 9
                }


                CalculatorButtons(symbol = "-", viewModel = CalculatorViewModel()) {
                    viewModel.addSymbol("-")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                CalculatorButtons(symbol = "4", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 4
                }


                CalculatorButtons(symbol = "5", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 5
                }


                CalculatorButtons(symbol = "6", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 6
                }


                CalculatorButtons(symbol = "+", viewModel = CalculatorViewModel()) {
                    viewModel.addSymbol("+")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                CalculatorButtons(symbol = "1", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 1
                }


                CalculatorButtons(symbol = "2", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 2
                }


                CalculatorButtons(symbol = "3", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 3
                }


                CalculatorButtons(symbol = "=", viewModel = CalculatorViewModel()) {
                    if(viewModel.expression.isNotBlank()){
                        viewModel.result = viewModel.solveExpression(expression = viewModel.expression)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){

                CalculatorButtons(symbol = viewModel.buttonIcon, viewModel = CalculatorViewModel()) {
                    viewModel.changeBackgroundColor()
                    viewModel.changeIcon()
                    viewModel.changeFontColor()
                }

                CalculatorButtons(symbol = "0", viewModel = CalculatorViewModel()) {
                    viewModel.expression += 0
                }


                CalculatorButtons(symbol = ".", viewModel = CalculatorViewModel()) {
                    viewModel.addSymbol(".")
                }


            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CalculatorScreenPreView() {
    CalculatorScreen(CalculatorViewModel())
}