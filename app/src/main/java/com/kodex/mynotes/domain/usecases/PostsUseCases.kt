package com.kodex.mynotes.domain.usecases

data class PostsUseCases(
    var getAllPosts: GetAllPosts,
    var uploadPost: UploadPost
) {
}