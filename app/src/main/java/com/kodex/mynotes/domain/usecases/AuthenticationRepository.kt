package com.kodex.mynotes.domain.usecases

import com.kodex.mynotes.presentation.ui.components.Response
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {

    fun isUserAuthenticatedInFirebase() : Boolean

    fun getFirebaseAuthState() : Flow<Boolean>

    fun firebaseSignIn(email:String,password:String) : Flow<Response<Boolean>>

    fun firebaseSignOut() : Flow<Response<Boolean>>

    fun firebaseSignUp(email:String,password:String,userName:String) : Flow<Response<Boolean>>
}
