package com.blanktheevil.koindemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blanktheevil.koindemo.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class KoinDemoViewModel(
    private val myRepository: MyRepository,
): ViewModel() {
    private val _uiState: MutableStateFlow<String?> = MutableStateFlow(null)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = myRepository.getApiData()
        }
    }
}