package com.kodex.mynotes.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.domain.usecases.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel(){
    fun addNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch {
            addNoteUseCase.invoke(note = note)
            Log.d("check", "AddViewModel note: $note")
            onSuccess()
        }
    }
}