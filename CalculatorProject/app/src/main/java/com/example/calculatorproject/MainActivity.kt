package com.example.calculatorproject

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorproject.ui.theme.CalculatorProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatotorMake()
                }
            }
        }
    }
}

@Composable
fun CalculatotorMake()
{
Column(modifier = Modifier
    .fillMaxSize()
    .background(color = Color(0xff0ffebe9d8))) {
    Row(Modifier.weight(1.75f)) {

    }
    Row(
        Modifier
            .weight((1f))
            .background(Color.Red)) {
        ComposableButtons("1", Color(0xff0ffebd8d8), modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("2",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("3",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("4",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
    }
    Row(
        Modifier
            .weight((1f))
            .background(Color.Red)) {
        ComposableButtons("5", Color(0xff0ffebd8d8), modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("6",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("7",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("8",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
    }
    Row(
        Modifier
            .weight((1f))
            .background(Color.Red)) {
        ComposableButtons("9", Color(0xff0ffebd8d8), modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("+",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("-",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("*",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
    }
    Row(
        Modifier
            .weight((1f))
            .background(Color.Red)) {
        ComposableButtons("%",Color(0xff0ffebd8d8), modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("/",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("=",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
        ComposableButtons("0",Color(0xff0ffebd8d8),  modifier = Modifier
            .weight(1f)
            .border(0.5.dp, Color.White)
            .fillMaxHeight())
    }
}
}




@Composable
private fun ComposableButtons(title:String,backgroundColor: Color, modifier: Modifier= Modifier)
{
    Column(modifier.fillMaxSize().background(backgroundColor).clickable { modifier.background(Color.Red) },verticalArrangement=Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally)
    {

        Text(title, fontWeight = FontWeight.Bold,fontSize = 45.sp, fontFamily = FontFamily.SansSerif)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorProjectTheme {
        CalculatotorMake()
    }
}