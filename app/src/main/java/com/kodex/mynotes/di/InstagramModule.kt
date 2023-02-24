package com.kodex.mynotes.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.kodex.mynotes.data.local.AuthenticationRepositoryImpl
import com.kodex.mynotes.data.local.PostRepositoryImpl
import com.kodex.mynotes.data.local.UserRepositoryImpl
import com.kodex.mynotes.domain.repository.PostRepository
import com.kodex.mynotes.domain.repository.UserRepository
import com.kodex.mynotes.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InstagramModule {


    @Singleton
    @Provides
    fun provideFirebaseAuthentication(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
    @Singleton
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Singleton
    @Provides
    fun provideAuthenticationRepository(auth:FirebaseAuth,firestore:FirebaseFirestore):AuthenticationRepository{
        return AuthenticationRepositoryImpl(auth = auth, firestore = firestore)
    }

    @Singleton
    @Provides
    fun provideAuthUseCases(repository: AuthenticationRepository)= AuthenticationUseCases(
        isUserAuthenticated = IsUserAuthenticated(repository = repository),
        firebaseAuthState = FirebaseAuthState(repository = repository),
        firebaseSignOut = FirebaseSignOut(repository = repository),
        firebaseSignIn = FirebaseSignIn(repository = repository),
        firebaseSignUp = FirebaseSignUp(repository = repository)
    )
    @Singleton
    @Provides
    fun provideUserRepository(firebaseFirestore:FirebaseFirestore): UserRepository {
        return UserRepositoryImpl(firebaseFirestore = firebaseFirestore)
    }
    @Singleton
    @Provides
    fun provideUserUseCases(repository:UserRepository)=UserUseCases(
        getUserDetails = GetUserDetails(repository = repository),
        setUserDetails = SetUserDetails(repository = repository)
    )

    @Provides
    @Singleton
    fun providePostRepository(firebaseFirestore: FirebaseFirestore):PostRepository{
        return PostRepositoryImpl(firebaseFirestore = firebaseFirestore)
    }

    @Provides
    @Singleton
    fun providePostsUseCases(repository: PostRepository) = PostsUseCases(
        getAllPosts = GetAllPosts(repository=repository),
        uploadPost = UploadPost(repository = repository)
    )
}


