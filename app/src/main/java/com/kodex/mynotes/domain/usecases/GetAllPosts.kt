package com.kodex.mynotes.domain.usecases

import com.kodex.mynotes.domain.repository.PostRepository
import dagger.Provides
import javax.inject.Inject


class GetAllPosts @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(userid: String) = repository.getAllPosts(userid = userid)
}