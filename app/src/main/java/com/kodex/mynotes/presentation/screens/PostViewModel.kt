package com.kodex.mynotes.presentation.screens

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.kodex.mynotes.domain.model.Post
import com.kodex.mynotes.domain.usecases.PostsUseCases
import com.kodex.mynotes.presentation.ui.components.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

    class PostViewModel @Inject constructor(
private val postsUseCases: PostsUseCases,
//private val auth: FirebaseAuth
) : ViewModel()
{
    private val _postData = mutableStateOf<Response<List<Post>>>(Response.Loading)
    val postData : State<Response<List<Post>>> = _postData

    private val _uploadPostData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val uploadPostData : State<Response<Boolean>> = _uploadPostData
    fun getAllPosts(){
      //  val userid = auth.currentUser?.uid!!
       // Log.d("check", "userid :$userid")
        viewModelScope.launch {
           // postsUseCases.getAllPosts(userid).collect {
            //    _postData.value = it
            }
        }
    }

    fun uploadPost(
        postImage:String,
        postDescription:String,
        time:Long,
        userid:String,
        userName:String,
        userImage:String
    ){
       /* viewModelScope.launch {
            postsUseCases.uploadPost(
                userName = userName,
                userImage = userImage, userid = userid,
                postImage = postImage,
                postDescription = postDescription,
                time = time,
            ).collect {
                _uploadPostData.value = it
            }
        }*/
   // }
}
