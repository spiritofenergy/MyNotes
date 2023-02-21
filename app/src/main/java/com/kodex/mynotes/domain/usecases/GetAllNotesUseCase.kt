package com.kodex.mynotes.domain.usecases

import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {
        suspend operator fun invoke() = noteRepository.getAllNotes()
}