package com.kodex.mynotes.presentation.navigation

 import androidx.compose.runtime.Composable
 import androidx.navigation.NavHostController
 import androidx.navigation.NavType
 import androidx.navigation.compose.NavHost
 import androidx.navigation.compose.composable
 import androidx.navigation.navArgument
 import com.kodex.mynotes.presentation.screens.*


sealed class Screens (val route: String){
    object MainScreen:Screens(route = "main_screen")
    object DetailsScreen:Screens(route = "detail_screen")
    object AddScreen:Screens(route = "add_screen")
    object FeedsScreen:Screens(route = "feed_screen")
    object LoginScreen:Screens(route = "login_screen")
    object SignUpScreen:Screens(route = "signup_screen")
}
@Composable
fun  SetupNavHost(navController : NavHostController, authenticationViewModel: AuthenticationViewModel) {
       NavHost(navController = navController,
       startDestination = Screens.MainScreen.route
       ){
composable(route = Screens.MainScreen.route){
  MainScreen(navController =  navController)
}
composable(route = Screens.AddScreen.route) {
    AddScreen(navController = navController)
}
composable(route = Screens.FeedsScreen.route){
    FeedsScreen(navController = navController)
}
composable(route = Screens.LoginScreen.route){
    LoginScreen(navController = navController, viewModel = authenticationViewModel)
}
composable(route = Screens.SignUpScreen.route){
    SignUpScreen(navController = navController, viewModel = authenticationViewModel)
}
composable(route = Screens.DetailsScreen.route + "/{id}",
    arguments = listOf(navArgument("id")
    {type = NavType.StringType})){
    DetailScreen(navController =  navController,  it.arguments?.getString("id"))
                }
       }
}


