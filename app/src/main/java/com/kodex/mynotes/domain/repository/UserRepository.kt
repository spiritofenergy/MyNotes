package com.kodex.mynotes.domain.repository

import com.kodex.mynotes.domain.model.User
import com.kodex.mynotes.presentation.ui.components.Response
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserDetails(userid:String): Flow<Response<User>>
    fun setUserDetails(
        userid:String,
        name:String,
        userName:String,
        bio:String,
        websiteUrl:String
    ): Flow<Response<Boolean>>
}