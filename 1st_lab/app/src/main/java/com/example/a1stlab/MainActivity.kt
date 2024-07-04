package com.example.a1stlab

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1stlab.ui.theme._1stLabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Marvel()
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Marvel() {
    val listState: LazyListState = rememberLazyListState()
    LazyColumn(modifier = Modifier
            .fillMaxSize() ,
            horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceBetween,
            ) {
        item(){
            Image(painter = painterResource(id = R.drawable.img),
                contentDescription = "Marvel"
                , modifier = Modifier
                    .fillParentMaxHeight(0.2f)
                    .size(300.dp)
                , contentScale = ContentScale.FillWidth)
        }
        item()
        {
            Text(text = "Choose Your Hero", fontSize = 15.sp)
        }
        item (){
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .fillParentMaxHeight(0.7f)
                ,horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                state = listState,
                flingBehavior = rememberSnapFlingBehavior(listState)
            ) {
                items(3)
                {
                    Card(modifier = Modifier.size(370.dp, 582.dp))
                    {
                        Text(text = "Item$it",
                            modifier = Modifier.offset(162.dp, 291.dp))
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Text("AHHAHAH")

}


