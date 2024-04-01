package com.example.news_app.presentation.favorite_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.news_app.data.repository.RoomRepository
import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val roomRepository: RoomRepository
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

    fun getFavoritesNews()  {
        val news = roomRepository.getFavoriteNews()
        _uiState.value = news
    }
}