package com.example.news_app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.news_app.R

sealed class ScreenBottomNav(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val iconId: Int
) {
    data object Feeds : ScreenBottomNav("feeds", R.string.feeds, R.drawable.ic_bn_feeds)
    data object Favorite : ScreenBottomNav("favorite", R.string.favorite, R.drawable.ic_bn_favorite)
    data object Profile : ScreenBottomNav("profile", R.string.profile, R.drawable.ic_bn_profile)
}