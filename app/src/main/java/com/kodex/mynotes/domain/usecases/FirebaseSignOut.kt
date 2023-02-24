package com.kodex.mynotes.domain.usecases

import javax.inject.Inject

class FirebaseSignOut @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke() = repository.firebaseSignOut()
}