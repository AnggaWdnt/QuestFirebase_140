package com.example.praktikum15.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum15.repository.Repositorymhs

class InsertViewModel (
    private val repositorymhs: Repositorymhs
): ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())
        private set

    var uiState: FormState by mutableStateOf(FormState.Idle)
        private set

    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiEvent = uiEvent.copy(
            insertUiEvent = mahasiswaEvent,
        )
    }