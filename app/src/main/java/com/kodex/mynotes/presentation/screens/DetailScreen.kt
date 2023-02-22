package com.kodex.mynotes.presentation.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme

@Composable
fun DetailScreen (navController: NavHostController){
    Text(text = "Detail")
}



@Preview(showBackground = true)
@Composable
fun PrevDetailScreen(){
    MyNotesTheme {
        DetailScreen(rememberNavController())
    }
}