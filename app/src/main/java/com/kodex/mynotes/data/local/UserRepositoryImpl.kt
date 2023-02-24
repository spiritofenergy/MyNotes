package com.kodex.mynotes.data.local

import com.google.firebase.firestore.FirebaseFirestore
import com.kodex.mynotes.domain.model.User
import com.kodex.mynotes.domain.repository.UserRepository
import com.kodex.mynotes.presentation.ui.components.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firebaseFirestore : FirebaseFirestore
) : UserRepository {
    private var operationSuccessful = false
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getUserDetails(userid: String): Flow<Response<User>> = callbackFlow {
        Response.Loading
        val snapShotListener = firebaseFirestore.collection("users")
            .document(userid)
            .addSnapshotListener{snapshot,error->
                val response = if(snapshot!=null){
                    val userInfo = snapshot.toObject(User::class.java)
                    Response.Success<User>(userInfo!!)
                }
                else{
                    Response.Error(error?.message?:error.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose{
            snapShotListener.remove()
        }
    }

    override fun setUserDetails(
        userid: String,
        name: String,
        userName: String,
        bio: String,
        websiteUrl: String,
    ): Flow<Response<Boolean>> = flow {
        operationSuccessful = false
        try{
            val userObj = mutableMapOf<String,String>()
            userObj["name"] = name
            userObj["userName"] = userName
            userObj["bio"] = bio
            userObj["websiteUrl"] = websiteUrl
            firebaseFirestore.collection("users").document(userid).update(userObj as Map<String, Any>)
                .addOnSuccessListener {

                }.await()
            if(operationSuccessful){
                emit(Response.Success(operationSuccessful))
            }
            else{
                emit(Response.Error("Edit Does Not Succed"))
            }
        }
        catch(e: Exception){
            Response.Error(e.localizedMessage?:"An Unexpected Error")
        }
    }

}
