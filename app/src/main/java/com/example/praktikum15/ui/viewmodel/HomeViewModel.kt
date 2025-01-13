package com.example.praktikum15.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum15.model.Mahasiswa
import com.example.praktikum15.repository.Repositorymhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repoMhs: Repositorymhs
): ViewModel(){
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.loading)
        private set

    fun getMhs() {
        viewModelScope.launch {
            repoMhs.getAllMhs().onStart {
                mhsUiState = HomeUiState.loading
            }
                .catch {
                    mhsUiState = HomeUiState.loading
                }
                .collect{
                    mhsUiState = if (it.isEmpty()) {
                        HomeUiState.Error(Exception("Belum ada data mahasiswa"))
                    } else {
                        HomeUiState.Success(it)
                    }
                }
        }
    }
}

sealed class HomeUiState{
    object loading : HomeUiState()

    data class Success(val data: List<Mahasiswa>) : HomeUiState()
    data class Error(val e: Throwable) : HomeUiState()
}