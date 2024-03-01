package com.example.dbpractice2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.dbpractice2.ui.theme.DBpractice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBpractice2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", context = this) // Pass context here
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context) {
    val database = Room.databaseBuilder(context, methodExtend::class.java, "tableStr").build()
    val yourDao=database.myDao()
    val entities:List<tableStr> = yourDao.getAll()
    val entity=tableStr(1,"Siddhant Jha")
    yourDao.insert(entity)

    LazyColumn(modifier=Modifier.fillMaxSize())
    {
        items(entities){entity->
            Text(text = entity.toString())
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DBpractice2Theme {
        Greeting("Android", context = LocalContext.current) // Pass context here
    }
}
