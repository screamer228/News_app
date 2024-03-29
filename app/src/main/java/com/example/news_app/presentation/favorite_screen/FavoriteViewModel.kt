package com.example.news_app.presentation.favorite_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.news_app.data.repository.RoomRepository
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

    fun getFavoritesNews()  {
        val news = roomRepository.getFavoriteNews()
        _uiState.value = news
        Log.d("database", "uiState updated")
    }

}