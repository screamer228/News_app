package com.example.news_app.presentation.feeds_screen.uistate

import com.example.news_app.R

sealed class ButtonCategory(
    val labelId: Int,
    val category: String
) {
    data object Healthy : ButtonCategory(R.string.healthy, "health")
    data object Technology : ButtonCategory(R.string.technology, "technology")
    data object Business : ButtonCategory(R.string.business, "business")
    data object Science : ButtonCategory(R.string.science, "science")
    data object Sports : ButtonCategory(R.string.sports, "sports")
}