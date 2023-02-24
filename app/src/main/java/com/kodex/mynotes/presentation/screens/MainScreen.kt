package com.kodex.mynotes.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.ui.components.NoteItem
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()
    val notes = viewModel.notes.observeAsState(listOf()).value
   // val notes: List<Note> = listOf(
      /*  Note(
            title = "Test",
            content = "Content",
            backgroundColor = Color(0xFFFF00FF).toArgb()
        )*/

   Scaffold(
       floatingActionButton = {
           FloatingActionButton(onClick = {
          navController.navigate(Screens.AddScreen.rout)
           }) {
           Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add" )
       }
       }
   ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Text(
                text = "Notes",
            fontSize = 42.sp,
            modifier = Modifier
                .padding(top = 43.dp, start = 24.dp, bottom = 12.dp)
            )
            notes.forEach{note->
                NoteItem(
                    title = note.title,
                    backgroundColor = Color(note.backgroundColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp)
                        .padding(horizontal = 4.dp)
                        .clickable {
                            navController.navigate(Screens.DetailsScreen.rout + "/${note.id}")
                        }
                )
            }
        }
   }
}

@Preview(showBackground = true)
@Composable
fun PrevMainScreen(){
    MyNotesTheme {
        MainScreen(rememberNavController())
    }
}