package com.kodex.mynotes.domain.usecases

import com.kodex.mynotes.domain.repository.UserRepository
import javax.inject.Inject

class GetUserDetails @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(userid: String) =
        repository.getUserDetails(userid = userid)
}
