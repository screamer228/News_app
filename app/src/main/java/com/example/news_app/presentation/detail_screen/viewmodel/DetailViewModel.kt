package com.example.news_app.presentation.detail_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.domain.usecase.deletefavoritenews.DeleteFavoriteNewsUseCase
import com.example.news_app.domain.usecase.getdetailnews.GetDetailNewsUseCase
import com.example.news_app.domain.usecase.getfavoritenews.GetFavoriteNewsUseCase
import com.example.news_app.domain.usecase.savefavoritenews.SaveFavoriteNewsUseCase
import com.example.news_app.presentation.detail_screen.DetailUiEvent
import com.example.news_app.presentation.detail_screen.uistate.DetailUiState
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
    private val getDetailNewsUseCase: GetDetailNewsUseCase,
    private val getFavoriteNewsUseCase: GetFavoriteNewsUseCase,
    private val saveFavoriteNewsUseCase: SaveFavoriteNewsUseCase,
    private val deleteFavoriteNewsUseCase: DeleteFavoriteNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var oldIsFavoriteState: Boolean = false

    private suspend fun getFavoriteNewsFromDB(title: String): DetailNews? {
        return getFavoriteNewsUseCase.getFavoriteNews(title)
    }

    private suspend fun getFavoriteNews(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getDetailNewsUseCase.getDetailNews(title)
            _uiState.value = _uiState.value.copy(news = news)
        }
    }

    fun initData(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val news = getFavoriteNewsFromDB(title)

            if (news != null) {
                _uiState.value = DetailUiState(news, true)
                oldIsFavoriteState = true
            } else {
                getFavoriteNews(title)
                changeIsFav(false)
                oldIsFavoriteState = false
            }
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
            oldIsFavoriteState && !currentLikedState -> deleteFavoriteNews(_uiState.value.news)
            !oldIsFavoriteState && currentLikedState -> saveFavoriteNews(_uiState.value.news)
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