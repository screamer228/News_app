package com.example.news_app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.news_app.R
import com.example.news_app.presentation.detail_screen.DetailScreen
import com.example.news_app.presentation.feeds_screen.FeedsScreen
import com.example.news_app.presentation.profile_screen.ProfileScreen
import com.example.news_app.presentation.favorite_screen.FavoriteScreen

@Composable
fun Navigation(
    navController: NavHostController,
    bottomItems: List<ScreenBottomNav>
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomItems.forEach { screen ->

                    val selected =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true

                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(screen.iconId),
                                contentDescription = null,
                                tint = colorResource(
                                    id =
                                    if (selected) R.color.primary
                                    else R.color.gray_bn
                                )
                            )
                        },
                        label = {
                            Text(
                                stringResource(screen.stringId),
                                color = colorResource(
                                    id =
                                    if (selected) R.color.black
                                    else R.color.gray_bn
                                )
                            )
                        },
                        selected = selected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = ScreenBottomNav.Feeds.route,
            Modifier.padding(innerPadding)
        )
        {
            composable(ScreenBottomNav.Feeds.route) { FeedsScreen(navController = navController) }
            composable(ScreenBottomNav.Favorite.route) { FavoriteScreen(navController = navController) }
            composable(ScreenBottomNav.Profile.route) { ProfileScreen(navController) }
            composable("$ROUTE_DETAIL_SCREEN$ARG_DETAIL_ROUTE") { navBackStackEntry ->
                val title = navBackStackEntry.arguments?.getString(KEY_DETAIL_ROUTE)
                title?.let {
                    DetailScreen(navController = navController, title = it)
                }
            }
        }
    }
}

const val ROUTE_DETAIL_SCREEN = "detail/"
const val KEY_DETAIL_ROUTE = "title"
const val ARG_DETAIL_ROUTE = "{title}"