package com.kodex.mynotes.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme
import com.kodex.mynotes.presentation.ui.theme.backgroundColor
import java.util.Random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<AddViewModel>()
    val isButtonEnabled by remember { mutableStateOf(false)
    }

    var title by rememberSaveable {mutableStateOf("")}
    var description by rememberSaveable {mutableStateOf("")}
    val color: Int = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
    ).toArgb()
    Scaffold(modifier = Modifier.background(Color(color = color)),
        topBar = {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 2.dp)
                    .background(Color(color = color))
            ) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .clickable {
                            navController.navigate(Screens.MainScreen.route)
                        }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "nav back",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .clickable {
                            viewModel.addNote(
                                Note(
                                    title = title,
                                    content = description,
                                    backgroundColor = color
                                )
                            ) {
                                Log.d("check", "Note: $title, $description, $backgroundColor")
                                navController.navigate(Screens.MainScreen.route)
                            }
                        },

                ) {
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "add note",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
                .background(Color(color = color)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            TextField(
                value = title,

                isError = title.isEmpty(),
                onValueChange = {title = it },
            label = { Text(text = "Title: ")},
                modifier = Modifier
                    .border(BorderStroke(width = 2.dp,
                    Color.White)),
            )
            TextField(
                value = description,
                isError = title.isEmpty(),
                onValueChange = {description = it },
            label = { Text(text = "Description: ")},
                modifier = Modifier.padding(top = 24.dp)
                    .border(BorderStroke(width = 2.dp,
                        Color.White)),
            )
        }
        
    }
}






@Preview(showBackground = true)
@Composable
fun PrevAddScreen(){
    MyNotesTheme {
        AddScreen(rememberNavController())
    }
}