package com.kodex.mynotes.di

import android.content.Context
import androidx.room.Room
import com.kodex.mynotes.data.local.NoteRepositoryImpl
import com.kodex.mynotes.data.local.dao.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModel  {
    @Provides
    fun provideAppDatabase (@ApplicationContext appContext: Context): AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "notes_database"
        ).build()
    }
    @Provides
    fun provideNoteDao (appDataBase: AppDataBase): NoteRepositoryImpl{
        return appDataBase.noteDao()
    }
}