package com.kodex.mynotes.domain.repository

import com.kodex.mynotes.domain.model.Post
import com.kodex.mynotes.presentation.ui.components.Response
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface PostRepository {

        fun getAllPosts(userid : String): Flow<Response<List<Post>>>

        fun uploadPost(
                postImage : String,
                postDescription : String,
                time : Long,
                userId : String,
                userName : String,
                userImage : String
        ) : Flow<Response<Boolean>>
}