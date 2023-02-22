package com.kodex.mynotes.presentation.navigation

 import androidx.compose.runtime.Composable
 import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import com.kodex.mynotes.presentation.screens.AddScreen
 import com.kodex.mynotes.presentation.screens.DetailScreen
 import com.kodex.mynotes.presentation.screens.MainScreen


sealed class Screens (val rout: String){
    object MainScreen:Screens(rout = "main_screen")
    object DetailsScreen:Screens(rout = "detail_screen")
    object AddScreen:Screens(rout = "add_screen")
}
@Composable
fun  SetupNavHost(navController : NavHostController) {
       NavHost(navController = navController,
       startDestination = Screens.MainScreen.rout
       ){
composable(route = Screens.MainScreen.rout){
  MainScreen(navController =  navController)
}
composable(route = Screens.AddScreen.rout){
    AddScreen(navController =  navController)
}
composable(route = Screens.DetailsScreen.rout){
    DetailScreen(navController =  navController)
                }
       }
}