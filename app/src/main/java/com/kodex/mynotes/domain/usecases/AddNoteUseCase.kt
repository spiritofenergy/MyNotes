package com.kodex.mynotes.domain.usecases

import com.kodex.mynotes.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

}