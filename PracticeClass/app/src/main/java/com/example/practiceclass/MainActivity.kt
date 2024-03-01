package com.example.practiceclass

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practiceclass.ui.theme.PracticeClassTheme
import com.google.ai.client.generativeai.type.content

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeClassTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val image1 = painterResource(R.drawable.image1)
    val image2 = painterResource(R.drawable.image2)
    val image3 = painterResource(R.drawable.image3)
    val image4 = painterResource(R.drawable.image4)
    val image5 = painterResource(R.drawable.image5)
    var AddedImages by remember { mutableStateOf(mutableStateListOf<Uri?>()) }
    var newImage by remember { mutableStateOf<Uri?>(null) }
    var text by remember { mutableStateOf("Hello") }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        newImage = uri
        AddedImages+=newImage
    }
    val onClick = { /* Do something */ }
    Box() {
        LazyColumn(
            modifier
                .fillMaxSize()
                .background(color = Color.Cyan),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            //adding an image using resource clas using dot operator.
            item() {
                Image(
                    painter = image1,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item() {
                Image(
                    painter = image2,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item() {
                Image(
                    painter = image4,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item() {
                Image(
                    painter = image1,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            items(AddedImages.size) {index->
                AsyncImage(
                    model = AddedImages[index],
                    contentDescription = "newly added images",
                    Modifier.fillMaxSize()
                )
            }
        }
        FloatingActionButton(
            onClick = { launcher.launch("image/*") },modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
        FloatingActionButton(
            onClick = {
               },modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp)
        ) {
            Icon(Icons.Filled.Create, "Floating action button.")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeClassTheme {
        Greeting("Android")
    }
}