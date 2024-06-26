package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.news_app.presentation.model.LatestNews
import com.example.news_app.utils.fillWidthOfParent

@Composable
fun FeedsLatestNews(
    navController: NavController,
    news: List<LatestNews>
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LatestNewsLabel(
            modifier = Modifier
        )
        SeeAll(
            modifier = Modifier
//                .clickable {
//                    NewsLazyColumn(
//                        news = news,
//                        navController = navController
//                    )
//                }
        )
    }
    LatestNewsLazyRow(
        modifier = Modifier
            .padding(
                top = 12.dp
            )
            .fillWidthOfParent(16.dp),
        news = news,
        navController = navController
    )
}