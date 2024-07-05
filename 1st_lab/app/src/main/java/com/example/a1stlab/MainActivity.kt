package com.example.a1stlab

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.a1stlab.ui.theme._1stLabTheme
import kotlinx.coroutines.joinAll


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "Main"
            ){
                composable("Main"){
                    Marvel(navController)
                }
                composable("DeadPool"){
                    DeadPool(navController)
                }
                composable("IronMan"){
                    IronMan(navController)
                }
                composable("SpiderMan"){
                    SpiderMan(navController)
                }
            }
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Marvel(navController: NavController) {
    Image(painter = painterResource(id = R.drawable.ic_main_background),
        modifier = Modifier.fillMaxSize(),
        contentDescription = "background",
        contentScale = ContentScale.FillWidth)
    val listState: LazyListState = rememberLazyListState()
    val painter_deadpool = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnAfIV.png")
            .size(Size.ORIGINAL)
            .build()
    )
    val painter_IronMan = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnuDI2.png")
            .size(Size.ORIGINAL)
            .build()
    )
    val painter_SpiderMan = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnuyB9.png")
            .size(Size.ORIGINAL)
            .build()
    )
    LazyColumn(modifier = Modifier
            .fillMaxSize() ,
            horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceAround,
            ) {
        item(){
            Image(painter = painterResource(id = R.drawable.mr),
                contentDescription = "Marvel"
                , modifier = Modifier
                    .fillParentMaxHeight(0.2f)
                    .size(300.dp)
                )
        }
        item()
        {
            Text(text = "Choose Your Hero", color = Color.White,
                fontSize = 30.sp)
        }
        item (){
            LazyRow(
                modifier = Modifier
                    .size(1200.dp, 582.dp)
                    .fillParentMaxHeight(0.7f)
                    .offset(10.dp, 10.dp)
                ,horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                state = listState,
                flingBehavior = rememberSnapFlingBehavior(listState)
            ) {
                item()
                {
                    Box(modifier = Modifier
                        .size(350.dp, 562.dp)
                        .clickable {
                            navController.navigate("DeadPool")
                        }
                        .background(color = Color.Transparent)
                    )
                    {

                        Image(painter = painter_deadpool,
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = "background",
                            contentScale = ContentScale.FillWidth)
                        Text(text = "Deadpool",
                                modifier = Modifier.offset(40.dp, 465.dp)
                            , color = Color.White,
                            fontSize = 30.sp)
                    }
                }
                item()
                {
                    Box(modifier = Modifier
                        .size(350.dp, 562.dp)
                        .clickable {
                            navController.navigate("IronMan")
                        }
                        .background(color = Color.Transparent)
                    )
                    {

                        Image(painter = painter_IronMan,
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = "background",
                            contentScale = ContentScale.FillWidth)
                        Text(text = "Iron Man",
                            modifier = Modifier.offset(40.dp, 465.dp)
                            , color = Color.White,
                            fontSize = 30.sp)
                    }
                }
                item()
                {
                    Box(modifier = Modifier
                        .size(350.dp, 562.dp)
                        .clickable {
                            navController.navigate("SpiderMan")
                        }
                        .background(color = Color.Transparent)
                    )
                    {

                        Image(painter = painter_SpiderMan,
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = "background",
                            contentScale = ContentScale.FillWidth)
                        Text(text = "Spider Man",
                            modifier = Modifier.offset(40.dp, 465.dp)
                            , color = Color.White,
                            fontSize = 30.sp)
                    }
                }
            }
        }
    }

}

@Composable
fun DeadPool(navController: NavController)
{
    val painter_deadpool = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnAfIV.png")
            .size(Size.ORIGINAL)
            .build()
    )

    Image(painter = painter_deadpool,
        modifier = Modifier.fillMaxSize(),
        contentDescription = "background",
        contentScale = ContentScale.FillHeight)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    )
    {
        Column()
        {
            Text(
                text = "DeadPoll",
                color = Color.White,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Please don’t make the super\u2028suit green...or animated!",
                color = Color.White,
                fontSize = 25.sp
            )
        }
    }

    Card(modifier = Modifier
        .size(75.dp, 75.dp)
        .clickable {
            navController.navigate("Main")
            {
                popUpTo("Main")
                {
                    inclusive = true
                }
            }
        }
        , colors = CardDefaults.cardColors(containerColor = Color.Transparent)){
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(75.dp, 75.dp)){item(){
                Image(painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "asd",
                    modifier = Modifier.size(30.dp))
        }
        }
    }
}
@Composable
fun IronMan(navController: NavController)
{
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnuDI2.png")
            .size(Size.ORIGINAL)
            .build()
    )

    Image(painter = painter,
        modifier = Modifier.fillMaxSize(),
        contentDescription = "background",
        contentScale = ContentScale.FillHeight)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    )
    {
        Column()
        {
            Text(
                text = "Iron Man",
                color = Color.White,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "I AM IRON MAN",
                color = Color.White,
                fontSize = 25.sp
            )
        }
    }

    Card(modifier = Modifier
        .size(75.dp, 75.dp)
        .clickable {
            navController.navigate("Main")
            {
                popUpTo("Main")
                {
                    inclusive = true
                }
            }
        }
        , colors = CardDefaults.cardColors(containerColor = Color.Transparent)){
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(75.dp, 75.dp)){item(){
            Image(painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "asd",
                modifier = Modifier.size(30.dp))
        }
        }
    }
}
@Composable
fun SpiderMan(navController: NavController)
{
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://iili.io/JMnuyB9.png")
            .size(Size.ORIGINAL)
            .build()
    )

    Image(painter = painter,
        modifier = Modifier.fillMaxSize(),
        contentDescription = "background",
        contentScale = ContentScale.FillHeight)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    )
    {
        Column()
        {
            Text(
                text = "Spider Man",
                color = Color.White,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "In iron suit",
                color = Color.White,
                fontSize = 25.sp
            )
        }
    }

    Card(modifier = Modifier
        .size(75.dp, 75.dp)
        .clickable {
            navController.navigate("Main")
            {
                popUpTo("Main")
                {
                    inclusive = true
                }
            }
        }
        , colors = CardDefaults.cardColors(containerColor = Color.Transparent)){
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(75.dp, 75.dp)){item(){
            Image(painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "asd",
                modifier = Modifier.size(30.dp))
        }
        }
    }
}


