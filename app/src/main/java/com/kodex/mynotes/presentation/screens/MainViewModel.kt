package com.kodex.mynotes.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.domain.usecases.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
): ViewModel(){
    private val _notes = MutableLiveData<List<Note>>()
        val notes: LiveData<List<Note>>
            get() = _notes

    init {
        getAllNotes()
    }
    private fun getAllNotes(){
        viewModelScope.launch {
            getAllNotesUseCase.invoke().let {
                _notes.postValue(it)
            }
        }
    }
}