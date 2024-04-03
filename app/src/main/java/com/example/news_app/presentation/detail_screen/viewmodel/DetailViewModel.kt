package com.example.news_app.presentation.detail_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.usecase.deletefavoritenews.DeleteFavoriteNewsUseCase
import com.example.news_app.domain.usecase.getfavoritenews.GetFavoriteNewsUseCase
import com.example.news_app.domain.usecase.savefavoritenews.SaveFavoriteNewsUseCase
import com.example.news_app.presentation.detail_screen.DetailUiEvent
import com.example.news_app.presentation.detail_screen.DetailUiState
import com.example.news_app.presentation.model.DetailNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getFavoriteNewsUseCase: GetFavoriteNewsUseCase,
    private val saveFavoriteNewsUseCase: SaveFavoriteNewsUseCase,
    private val deleteFavoriteNewsUseCase: DeleteFavoriteNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var oldFavoriteState: Boolean = false

    init {
        isAlreadyFavorite()
    }

    private fun isAlreadyFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getFavoriteNewsUseCase.getFavoriteNews(uiState.value.news.title)
            oldFavoriteState = news != null
            _uiState.value = _uiState.value.copy(isFavorite = oldFavoriteState)
        }
    }

    private fun saveFavoriteNews(news: DetailNews) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoriteNewsUseCase.saveFavoriteNews(news)
        }
    }

    private fun deleteFavoriteNews(news: DetailNews) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFavoriteNewsUseCase.deleteFavoriteNews(news)
        }
    }

    fun checkCurrentLikedState() {
        val currentLikedState = uiState.value.isFavorite
        when {
            oldFavoriteState && !currentLikedState -> deleteFavoriteNews(_uiState.value.news)
            !oldFavoriteState && currentLikedState -> saveFavoriteNews(_uiState.value.news)
        }
    }

    fun postUiEvent(event: DetailUiEvent) {
        when (event) {
            is DetailUiEvent.LikeClick -> changeIsFav(event.isFavorite)
            is DetailUiEvent.BackClick -> TODO()
        }
    }

    private fun changeIsFav(bool: Boolean) {
        _uiState.value = _uiState.value.copy(isFavorite = bool)
    }
}