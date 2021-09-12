package xyz.jalalkun.composebasicnavigation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ScreenKedua(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        Text(
            text = "Recycler View Card",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(50.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )

        val charPool : List<Char> = ('a'..'z') + ('A'..'Z')
        val itemlist = arrayListOf<String>()
        repeat(50){
            val randomString = (10..30)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
            itemlist.add(randomString)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(items = itemlist, itemContent = { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    backgroundColor = Color.LightGray
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            })
        }
    }
}

@Preview
@Composable
fun Prev(){
    ScreenKedua(navHostController = NavHostController(LocalContext.current))
}