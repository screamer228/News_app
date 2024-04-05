package com.example.news_app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.news_app.R

sealed class ScreenBottomNav(
    val route: String,
    @StringRes val stringId: Int,
    @DrawableRes val iconId: Int
) {
    data object Feeds : ScreenBottomNav(ROUTE_FEEDS_SCREEN, R.string.feeds, R.drawable.ic_bn_feeds)
    data object Favorite : ScreenBottomNav(ROUTE_FAVORITE_SCREEN, R.string.favorite, R.drawable.ic_bn_favorite)
    data object Profile : ScreenBottomNav(ROUTE_PROFILE_SCREEN, R.string.profile, R.drawable.ic_bn_profile)
}

const val ROUTE_FEEDS_SCREEN = "feeds"
const val ROUTE_FAVORITE_SCREEN = "favorite"
const val ROUTE_PROFILE_SCREEN = "profile"