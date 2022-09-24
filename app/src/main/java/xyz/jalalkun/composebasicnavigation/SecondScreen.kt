package xyz.jalalkun.composebasicnavigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import com.jalalkun.apiservice.ProfileViewModel
import com.jalalkun.apiservice.models.Profile
import com.jalalkun.apiservice.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.koin.androidx.compose.getViewModel

@Composable
fun SecondScreen(navHostController: NavHostController){
    val composableScope = rememberCoroutineScope()
    val viewModel = getViewModel<ProfileViewModel>()
    composableScope.launch {
        Log.e("SecondScreen", "coroutine call" )
        viewModel.getProfiles()
    }
    Scaffold {
        SecondScreenView(resource = viewModel.getProfiles.collectAsState().value)
    }
}

@Composable
private fun SecondScreenView(resource: Resource){
    when(resource){
        is Resource.Success<*> -> {
            ResultScreen(
                if (resource.data is List<*>){
                    (resource.data as List<*>).filterIsInstance<Profile>()
                }else{
                    listOf()
                }
            )
        }
        is Resource.Error -> {
            Error(resource.message)
        }
        is Resource.Loading -> {
            Loading()
        }
        else -> {
            Text(text = "Else....")
        }
    }
}

@Composable
private fun Error(message: String){
    Text(text = "Error $message")
}

@Composable
private fun Loading(){
    Text(text = "Loading....")
}

@Composable
private fun ResultScreen(list: List<Profile>){
    Scaffold {
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(items = list, itemContent = { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(shape = RoundedCornerShape(4.dp)),
                        backgroundColor = Color.LightGray
                    ) {
                        Text(
                            text = "${item.name?.title} ${item.name?.first} ${item.name?.last}",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                })
            }
        }
    }
}

@Preview
@Composable
fun Prev(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
        backgroundColor = Color.LightGray
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Mr JalalKun",
                    modifier = Modifier.padding(8.dp)
                )
                Text(text = "Image",
                    modifier = Modifier.align(Alignment.End)
                    )
            }
        }
    }
}