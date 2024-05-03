package pl.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception

class CalculatorViewModel: ViewModel() {
    var result by mutableStateOf("")
    var expression by mutableStateOf("")
    var backgroundColor by mutableStateOf(Color.Black)
    var isColorBlack by mutableStateOf(true)
    var buttonIcon by mutableStateOf("☼")
    var fontColor by mutableStateOf(Color.Green)



    fun delCharacter(expression: String): String{
    if(expression.isNotBlank()){
        return expression.substring(0, expression.length - 1)
    }
       else{
           return expression
       }
   }
    fun addSymbol(symbol: String): Any {
        return if(expression.contains(symbol) || expression.length <= 0){
            expression
        } else{
            expression += symbol
        }
    }

    fun solveExpression(expression: String): String{
       val answer = Expression(expression
            .replace('x', '*')
            ).calculate().toString()
        return answer
    }

    fun changeBackgroundColor(){
        if(isColorBlack){
            backgroundColor = Color.White
            isColorBlack = false
        }
        else if(!isColorBlack){
            backgroundColor = Color.Black
            isColorBlack = true
        }
    }

    fun changeIcon(){
        if (isColorBlack){
            buttonIcon = "☼"
        }
        else if(!isColorBlack){
            buttonIcon = "☾"
        }
    }

    fun changeFontColor(){
        if (isColorBlack){
            fontColor = Color.Green
        }
        else if(!isColorBlack){
            fontColor = Color.Black
        }
    }

}