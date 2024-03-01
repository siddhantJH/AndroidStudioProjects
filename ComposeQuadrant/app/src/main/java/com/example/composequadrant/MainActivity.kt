package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.textHeading),
                description = stringResource(R.string.textDescrip),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.imageHeading),
                description = stringResource(R.string.imageDescrip),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.rowHeading),
                description = stringResource(R.string.rowDescrip),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.columnHeading),
                description = stringResource(R.string.columnDescrip),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
//It's a best practice to have all of your composables accept a modifier parameter,
// and pass that modifier to its first child that emits UI.
// Doing so makes your code more reusable and makes its behavior more predictable and intuitive.
@Composable
private fun ComposableInfoCard(title:String,description:String,backgroundColor:Color,modifier: Modifier= Modifier)
{
    Column(modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp),verticalArrangement=Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally)  {
        Text(title,modifier=Modifier.padding(bottom=16.dp), fontWeight = FontWeight.Bold)
        Text(description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun Compose4cardsPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}