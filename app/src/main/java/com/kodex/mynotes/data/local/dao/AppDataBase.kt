package com.kodex.mynotes.data.local.dao

import androidx.room.Database
import com.kodex.mynotes.data.local.NoteRepositoryImpl
import com.kodex.mynotes.domain.model.Note

@Database(entities = [Note::class], version = 1)
 abstract class AppDataBase{
     abstract fun noteDao(): NoteRepositoryImpl
 }
