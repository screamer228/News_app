package com.example.news_app.presentation.detail_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.presentation.detail_screen.DetailUiEvent
import com.example.news_app.presentation.detail_screen.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var oldFavoriteState: Boolean = false

    fun postUiEvent(event: DetailUiEvent) {
        when (event) {
            is DetailUiEvent.LikeClick -> changeIsFav(event.isFavorite)
            is DetailUiEvent.BackClick -> TODO()
        }
    }

    init {
        isAlreadyFavorite()
    }

    private fun saveFavoriteNews(news: DetailNewsDBO) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepository.insertFavoriteNews(news)
        }
    }

    private fun isAlreadyFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = roomRepository.getNewsByTitle(uiState.value.news.title)
            oldFavoriteState = news != null
            _uiState.value = _uiState.value.copy(isFavorite = oldFavoriteState)
        }
    }

    private fun deleteFavoriteNews(news: DetailNewsDBO) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepository.deleteFavoriteNews(news)
        }
    }

    fun checkCurrentLikedState() {
        val currentLikedState = uiState.value.isFavorite
        when {
            oldFavoriteState && !currentLikedState -> deleteFavoriteNews(_uiState.value.news)
            !oldFavoriteState && currentLikedState -> saveFavoriteNews(_uiState.value.news)
        }
    }

    private fun changeIsFav(bool: Boolean) {
        _uiState.value = _uiState.value.copy(isFavorite = bool)
    }
}