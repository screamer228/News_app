package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.news_app.model.LatestNews
import com.example.news_app.utils.fillWidthOfParent

@Composable
fun FeedsLatestNews(navController: NavController){
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
        )
    }
    LatestNewsLazyRow(
        modifier = Modifier
            .padding(
                top = 12.dp
            )
            .fillWidthOfParent(16.dp),
        news = listOf(
            LatestNews(
                "Houston outlasts Texas A&M in OT, advances in NCAA tournament - ESPN",
                "https://a2.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0325%2Fr1309682_1296x729_16%2D9.jpg"
            ),
            LatestNews(
                "137 school children kidnapped by gunmen in Nigeria released, undergoing ‘psychosocial counseling,’ official says - CNN",
                "https://media.cnn.com/api/v1/images/stellar/prod/ap24084242488722.jpg?c=16x9&q=w_800,c_fill"
            )
        ),
        navController = navController
    )
}