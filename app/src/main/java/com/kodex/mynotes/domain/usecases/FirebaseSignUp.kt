package com.kodex.mynotes.domain.usecases

import javax.inject.Inject

class FirebaseSignUp @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email:String,password:String,userName:String)
            = repository.firebaseSignUp(email, password, userName)
}