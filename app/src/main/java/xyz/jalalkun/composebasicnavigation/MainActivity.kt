package xyz.jalalkun.composebasicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.jalalkun.composebasicnavigation.ui.theme.ComposeBasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicNavigationTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InitNavigation()
                }
            }
        }
    }
}

@Composable
fun InitNavigation() {
    val navController = rememberNavController()
    Scaffold {
        Navigation(navController = navController)
    }
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main_screen"){
        composable("main_screen"){
            MainScreen(navHostController = navController)
        }
        composable("screen_kedua"){
            SecondScreen(navHostController = navController)
        }
        composable("screen_ketiga"){
            ScreenKetiga(navHostController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicNavigationTheme {
        InitNavigation()
    }
}