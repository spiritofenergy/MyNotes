package com.kodex.mynotes.domain.usecases

import javax.inject.Inject

class FirebaseSignIn @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email:String,password:String) = repository.firebaseSignIn(email, password)
}