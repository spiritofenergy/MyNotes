package com.kodex.mynotes.domain.usecases

import androidx.compose.ui.platform.LocalContext
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.insertNote(note = note)


}