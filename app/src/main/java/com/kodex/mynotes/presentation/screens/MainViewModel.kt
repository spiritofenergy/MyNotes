package com.kodex.mynotes.presentation.screens

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.kodex.mynotes.domain.model.Note
import com.kodex.mynotes.domain.usecases.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
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
        Log.d("check", "Item notes getAllNotes: $notes")

    }
    private fun getAllNotes(){
        viewModelScope.launch {
            getAllNotesUseCase.invoke().let {
                _notes.postValue(it)
            }
        }
    }
    /*val color: Int = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
    ).toArgb()
    backgroundColor Int*/

}