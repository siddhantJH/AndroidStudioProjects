package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MakeLemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeImageAndText(name: String, modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember{ mutableStateOf(1) }
    val ImageResource=when(result)
    {
        1 -> painterResource(id = R.drawable.lemon_tree)
        2 -> painterResource(id = R.drawable.lemon_squeeze)
        3 -> painterResource(id = R.drawable.lemon_drink)
        else -> painterResource(id = R.drawable.lemon_restart)
    }
    val strRes=when(result)
    {
        1->R.string.image1
        2->R.string.image2
        3->R.string.image3
        else ->R.string.image4
    }
    val strContent=when(result)
    {
        1->R.string.LemonTree
        2->R.string.Lemon
        3->R.string.GlassofLemonade
        else ->R.string.EmptyGlass
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

            Image(painter = ImageResource,
                contentDescription = stringResource(id =strContent),
                modifier= Modifier
                    .background(color = Color.Cyan)
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight(0.35f)
                    .clickable {
                        if (result == 5) {
                            result = 1
                        } else {
                            result = result + 1
                        }
                    })
            Text(text = stringResource(id = strRes))
    }
}

@Preview(showBackground = true)
@Composable
fun MakeLemonadeApp() {
    LemonadeAppTheme {
        LemonadeImageAndText("Android")
    }
}