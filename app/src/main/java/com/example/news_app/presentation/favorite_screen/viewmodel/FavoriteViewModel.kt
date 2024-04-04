package com.example.news_app.presentation.favorite_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.usecase.getfavoritelist.GetFavoriteListUseCase
import com.example.news_app.presentation.favorite_screen.uistate.FavoriteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteListUseCase: GetFavoriteListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        FavoriteUiState(
            listOf()
        )
    )
    val uiState: StateFlow<FavoriteUiState> = _uiState.asStateFlow()

    init {
        getFavoritesList()
    }

    fun getFavoritesList() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getFavoriteListUseCase.getFavoriteList()
            _uiState.value = news
        }
    }
}