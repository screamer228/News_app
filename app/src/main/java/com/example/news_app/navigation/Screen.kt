package com.example.news_app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.news_app.R

sealed class Screen(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val iconId: Int
) {
    data object Feeds : Screen("feeds", R.string.feeds, R.drawable.ic_bn_feeds)
    data object Favorite : Screen("favorite", R.string.favorite, R.drawable.ic_bn_favorite)
    data object Profile : Screen("profile", R.string.profile, R.drawable.ic_bn_feeds)
}