package xyz.jalalkun.composebasicnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Main Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )

        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.DarkGray),
            shape = RoundedCornerShape(4.dp),
            onClick = {navHostController.navigate("screen_kedua")}
        ){
            Text(
                text = "Ke List Card",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.DarkGray),
            shape = RoundedCornerShape(4.dp),
            onClick = {navHostController.navigate("screen_ketiga")}
        ){
            Text(
                text = "Ke Screen Ketiga",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}