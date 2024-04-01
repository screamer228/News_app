package com.example.news_app.presentation.feeds_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.news_app.presentation.feeds_screen.FeedsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FeedsViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(FeedsUiState())
    val uiState: StateFlow<FeedsUiState> = _uiState.asStateFlow()

    fun getLatestNews() {

    }

    fun getColumnNews() {

    }
}