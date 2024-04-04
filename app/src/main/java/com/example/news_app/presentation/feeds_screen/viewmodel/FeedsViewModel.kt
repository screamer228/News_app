package com.example.news_app.presentation.feeds_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.usecase.getcategorynews.GetCategoryNewsUseCase
import com.example.news_app.domain.usecase.getcolumnnews.GetColumnNewsUseCase
import com.example.news_app.domain.usecase.getlatestnews.GetLatestNewsUseCase
import com.example.news_app.presentation.feeds_screen.uistate.FeedsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedsViewModel @Inject constructor(
    private val getLatestNewsUseCase: GetLatestNewsUseCase,
    private val getCategoryNewsUseCase: GetCategoryNewsUseCase,
    private val getColumnNewsUseCase: GetColumnNewsUseCase
) : ViewModel() {

    var country = "us"
    var category = "health"

    private val _uiState = MutableStateFlow(FeedsUiState())
    val uiState: StateFlow<FeedsUiState> = _uiState.asStateFlow()

    init {
        getLatestNews()
        getCategoryNews()
    }

    fun getLatestNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getLatestNewsUseCase.getLatestNews(country)
            _uiState.value = _uiState.value.copy(latestNews = news)
        }
    }

    fun getCategoryNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getCategoryNewsUseCase.getCategoryNews(category)
            _uiState.value = _uiState.value.copy(categoryNews = news)
        }
    }

    fun getColumnNews() {

    }
}