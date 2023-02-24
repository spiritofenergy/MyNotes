package com.kodex.mynotes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.navigation.SetupNavHost
import com.kodex.mynotes.presentation.screens.AuthenticationViewModel
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyNotesTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    val authViewModel : AuthenticationViewModel = hiltViewModel()
                    SetupNavHost(navController = navController,authenticationViewModel = authViewModel)
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNotesTheme {
        Screens.MainScreen
    }
}*/
