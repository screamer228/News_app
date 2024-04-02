package com.example.news_app.presentation.favorite_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.domain.usecase.GetFavoriteNewsUseCase
import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteNewsUseCase: GetFavoriteNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        FavoriteUiState(
            listOf()
        )
    )
    val uiState: StateFlow<FavoriteUiState> = _uiState.asStateFlow()

    init {
        getFavoritesNews()
    }

    fun getFavoritesNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getFavoriteNewsUseCase.getFavoriteNews()
            _uiState.value = news
        }
    }
}