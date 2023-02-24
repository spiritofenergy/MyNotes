package com.kodex.mynotes.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.navigation.Screens.DetailsScreen


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
          navController.navigate(Screens.AddScreen.route)
           }) {
           Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add" )
       }
       }
   ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
       ) {
           Text(
               text = "Notes",
               color = Color(0xFF2196F3),
               fontSize = 42.sp,
               modifier = Modifier
                   .padding(top = 43.dp, start = 24.dp, bottom = 12.dp)
           )
           Box{
               LazyColumn{
                   items(notes){ note ->
                       NoteItem(note = note,
                           navController = navController )
                   }
               }
           }
       }
   }
}
@Composable
fun NoteItem(note: Note, navController: NavController,) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 2.dp, horizontal = 4.dp)
        .clickable {
            navController.navigate(DetailsScreen.route + "/${note.id}")
        },
        backgroundColor = Color(note.backgroundColor),
        elevation = 6.dp){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .clip(RoundedCornerShape(10.dp))

        ) {
            Text(
                text = note.title,
                fontSize = 25.sp,
                color = Color(0xFF303030),
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(vertical = 22.dp)
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun PrevMainScreen(){
    val viewModel = hiltViewModel<MainViewModel>()
    val notes = viewModel.notes.observeAsState(listOf()).value



    }



/*
* notes.forEach{note->
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
@Composable
fun NoteItem(title: String,
             backgroundColor: Color,
             modifier: Modifier) {
    Box(modifier = modifier){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                color = Color(0xFF303030),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 22.dp)
            )

        }
    }
}
* */