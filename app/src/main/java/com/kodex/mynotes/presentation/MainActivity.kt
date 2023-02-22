package com.kodex.mynotes.presentation

import android.os.Bundle
import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.kodex.mynotes.data.local.listener.ClickListener
import com.kodex.mynotes.data.local.listener.SwipeListener
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.navigation.SetupNavHost
import com.kodex.mynotes.presentation.screens.AddViewModel
import com.kodex.mynotes.presentation.screens.DetailViewModel
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() , SwipeListener, ClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    SetupNavHost(navController = navController,
                        listener = this,
                        clickListener = this
                    )
                }
            }
        }
    }

    override fun onRiteSwipe() {
       Log.d("check","onRiteSwipe")
    }
    override fun onLeftSwipe() {
       Log.d("check","onLeftSwipe")
    }

    override fun onClick() {
        Log.d("check","onClick")
    }

    override fun onLongClick() {
        Log.d("check","onLongClick")
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
