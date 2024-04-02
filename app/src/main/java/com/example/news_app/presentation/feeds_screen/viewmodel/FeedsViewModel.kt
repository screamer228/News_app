package com.example.news_app.presentation.feeds_screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.usecase.latestnews.GetLatestNewsUseCase
import com.example.news_app.presentation.feeds_screen.FeedsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedsViewModel @Inject constructor(
    private val getLatestNewsUseCase: GetLatestNewsUseCase
) : ViewModel() {

    var country = "us"

    private val _uiState = MutableStateFlow(FeedsUiState())
    val uiState: StateFlow<FeedsUiState> = _uiState.asStateFlow()

    init {
        getLatestNews()
    }

    fun getLatestNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getLatestNewsUseCase.getLatestNews(country)
            _uiState.value = _uiState.value.copy(latestNews = news)
            Log.d("retrofitTest", "uiState: ${news.size}")
        }
    }

    fun getColumnNews() {

    }
}