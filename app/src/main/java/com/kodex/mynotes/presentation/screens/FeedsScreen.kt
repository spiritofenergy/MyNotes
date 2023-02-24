package com.kodex.mynotes.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kodex.mynotes.presentation.navigation.Screens
import com.kodex.mynotes.presentation.ui.components.InstagramHomeContent
import com.kodex.mynotes.presentation.ui.components.Response
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun  FeedsScreen(navController: NavController) {
    val postsViewModel : PostViewModel = hiltViewModel()
    postsViewModel.getAllPosts()

                Box(
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .height(48.dp)
                        .padding(horizontal = 24.dp)
                        .width(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFF383838))
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

    when (val response = postsViewModel.postData.value) {

        is Response.Loading -> {
            CircularProgressIndicator()
            Log.d("check", "response: $response")
        }
        is Response.Success -> {
            val obj = response.data
            var selectedTabIndex by remember { mutableStateOf(0) }
            Scaffold(
               /* topBar = {
                    TopAppBar(
                        title = { Text(text = "Instagram") },
                        backgroundColor = MaterialTheme.colors.surface,
                        contentColor = MaterialTheme.colors.onSurface,
                        elevation = 8.dp,
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_instagram),
                                    contentDescription = "logo",
                                    tint = Color.Unspecified
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_message),
                                    contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = Color.Black
                                )
                            }
                        }
                    )
                },*/
                content = {
                    InstagramHomeContent()
                },

            )
        }
        is Response.Error ->{
           // Toast(message = response.message)
        }
    }
}




