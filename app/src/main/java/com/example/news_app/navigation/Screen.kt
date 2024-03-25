package com.example.news_app.navigation

import androidx.annotation.StringRes
import com.example.news_app.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object Feeds : Screen("feeds", R.string.feeds)
    data object Search : Screen("search", R.string.search)
    data object Profile : Screen("profile", R.string.profile)
}