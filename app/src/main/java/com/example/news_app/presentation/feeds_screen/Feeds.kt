package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.news_app.R
import com.example.news_app.presentation.search_screen.SearchBar
import com.example.news_app.model.NewsResult
import com.example.news_app.utils.fillWidthOfParent

@Composable
fun FeedsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LatestNews(
                modifier = Modifier
            )
            SeeAll(
                modifier = Modifier
            )
        }
        LatestNewsLazyRow(
            modifier = Modifier
                .padding(
                    top = 24.dp
                ),
            news = listOf(
                NewsResult(
                    "Houston outlasts Texas A&M in OT, advances in NCAA tournament - ESPN",
                    "https://a2.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0325%2Fr1309682_1296x729_16%2D9.jpg"
                ),
                NewsResult(
                    "137 school children kidnapped by gunmen in Nigeria released, undergoing ‘psychosocial counseling,’ official says - CNN",
                    "https://media.cnn.com/api/v1/images/stellar/prod/ap24084242488722.jpg?c=16x9&q=w_800,c_fill"
                )
            )
        )
        ButtonsLazyRow(
            modifier = Modifier
                .padding(
                    top = 12.dp
                )
                .fillWidthOfParent(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    FeedsScreen(rememberNavController())
}

@Composable
fun LatestNews(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.latest_news),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SeeAll(modifier: Modifier) {
    Text(
        text = stringResource(R.string.see_all),
        modifier = modifier,
        color = colorResource(R.color.blue),
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    )
}