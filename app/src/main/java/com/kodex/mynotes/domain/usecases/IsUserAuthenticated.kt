package com.kodex.mynotes.domain.usecases

import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthenticationRepository
){
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}