package com.kodex.mynotes.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kodex.mynotes.data.local.NoteRepositoryImpl
import com.kodex.mynotes.domain.model.Note

@Database(entities = [Note::class], version = 1)
 abstract class AppDataBase: RoomDatabase(){
     abstract fun noteDao(): NoteRepositoryImpl
 }
