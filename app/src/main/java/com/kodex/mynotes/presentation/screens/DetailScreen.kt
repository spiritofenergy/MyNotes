package com.kodex.mynotes.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.ui.theme.MyNotesTheme
import com.kodex.mynotes.presentation.ui.theme.backgroundColor
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen (navController: NavHostController, id: String?){

    val context = LocalContext.current
    val viewModel = hiltViewModel<DetailViewModel>()
    val note = viewModel.note.observeAsState().value
    Log.d("check", "DetailScreen: $note")

    id?.toLong()?.let { viewModel.getNoteById(id = it)
    }

    Scaffold(
        topBar = {
            if (note != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 4.dp)
                        .background(Color(note.backgroundColor))
                ) {
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
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
                            .background(Color(note.backgroundColor))

                    ) {
                        Icon(imageVector = Icons.Filled.Delete,
                            contentDescription = "delete note",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clickable {
                                    viewModel.deleteNote{
                                        navController.navigate(Screens.MainScreen.route)
                                        Toast.makeText(context, "Дело сделано", Toast.LENGTH_SHORT).show()
                                    }


                                }
                        )
                    }
                }
            }
        }
    ) {
        if (note != null) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 2.dp)
                .padding(horizontal = 4.dp)
                .background(Color(note.backgroundColor)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,


                ) {
                Text(
                    text = note?.title ?: "",
                    fontSize = 35.sp,
                    style = TextStyle(
                        color = Color(0xFF303030),
                        fontWeight = FontWeight.Bold)
                )
                Text(
                    text = note?.content ?: "",
                    fontSize = 23.sp,
                    style = TextStyle(
                        color = Color(0xFF303030),
                        fontWeight = FontWeight.Light)
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PrevDetailScreen(){
    MyNotesTheme {
     //   DetailScreen(rememberNavController())
    }
}