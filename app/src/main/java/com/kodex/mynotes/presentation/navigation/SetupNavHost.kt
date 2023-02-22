package com.kodex.mynotes.presentation.navigation

 import androidx.compose.material.ExperimentalMaterialApi
 import androidx.compose.runtime.Composable
 import androidx.navigation.NavHostController
 import androidx.navigation.NavType
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.navArgument
 import com.kodex.mynotes.data.local.listener.ClickListener
 import com.kodex.mynotes.data.local.listener.SwipeListener
 import com.kodex.mynotes.presentation.screens.AddScreen
 import com.kodex.mynotes.presentation.screens.DetailScreen
 import com.kodex.mynotes.presentation.screens.MainScreen


sealed class Screens (val route: String){
    object MainScreen:Screens(route = "main_screen")
    object DetailsScreen:Screens(route = "detail_screen")
    object AddScreen:Screens(route = "add_screen")
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun  SetupNavHost(navController : NavHostController, listener: SwipeListener,
                  clickListener: ClickListener
) {
       NavHost(navController = navController,

       startDestination = Screens.MainScreen.route
       ){
composable(route = Screens.MainScreen.route){
  MainScreen(navController =  navController, listener  = listener, clickListener = clickListener)
}
composable(route = Screens.AddScreen.route){
    AddScreen(navController =  navController)
}
composable(route = Screens.DetailsScreen.route + "/{id}", arguments = listOf(navArgument("id"){type = NavType.StringType})){
    DetailScreen(navController =  navController, it.arguments?.getString("id"))
                }
       }
}