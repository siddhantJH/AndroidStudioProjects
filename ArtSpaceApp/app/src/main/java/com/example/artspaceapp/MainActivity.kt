package com.example.artspaceapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppElements(modifier: Modifier = Modifier)
{
    var value by remember{ mutableStateOf(0) }
    var imageRes=when(value)
    {
        1->R.drawable.img1
        2->R.drawable.img2
        3->R.drawable.img3
        4->R.drawable.img4
        else -> R.drawable.img5
    }
    var strArtist=when(value)
    {
        1->R.string.p1
        2->R.string.p2
        3->R.string.p3
        4->R.string.p4
        else -> R.string.p5
    }
    Column(modifier=Modifier.fillMaxSize()) {
        Row(modifier= Modifier
            .fillMaxHeight(0.70f)
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(start = 30.dp, 0.dp, end = 30.dp, 0.dp)
            .background(color = Color.White), verticalAlignment = Alignment.CenterVertically)
        {
            Image(painter = painterResource(id = imageRes), contentDescription = null,modifier= Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .shadow(4.dp))
        }
        Row(modifier= Modifier
            .fillMaxHeight(0.65f)
            .background(color = Color.White)
            .fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
        {
            Column(modifier= Modifier
                .fillMaxWidth(0.80f)
                .fillMaxHeight(0.9f)
                .padding(top = 15.dp)
                .background(color = Color(0xffECEBF4))
                .clip(shape = RoundedCornerShape(16.dp)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = stringResource(id = strArtist), fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Text(text = stringResource(id = strArtist))
            }

        }
        Row(modifier= Modifier
            .fillMaxHeight(1f)
            .background(color = Color.White)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically)
        {
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = { value=value-1
                if(value<=0){
                        value=0
            } },modifier.weight(1.1f)) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(50.dp))
            Button(onClick = { value=value+1
                                if(value>=5)
                                {
                                    value=5
                                }
                             },modifier.weight(1.1f)) {
                Text(text = "Next",modifier=Modifier.padding(15.dp,0.dp,15.dp,0.dp))
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceAppTheme {
        ArtSpaceAppElements()
    }
}