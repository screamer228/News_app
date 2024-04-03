package com.example.news_app.presentation.feeds_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.news_app.R
import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.presentation.feeds_screen.viewmodel.FeedsViewModel
import com.example.news_app.presentation.model.ColumnNews
import com.example.news_app.utils.fillWidthOfParent

@Composable
fun FeedsScreen(
    viewModel: FeedsViewModel = hiltViewModel(),
    navController: NavController
) {

    val uiState by viewModel.uiState.collectAsState()

    val isSearch = remember { mutableStateOf(false) }

    BackHandler {
        isSearch.value = false
    }

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
                .onFocusEvent {
                    isSearch.value = !isSearch.value
                }
                .fillMaxWidth()
                .border(
                    1.dp,
                    colorResource(R.color.gray_light),
                    RoundedCornerShape(24.dp)
                )
        )

        if (isSearch.value) {
            FeedsLatestNews(
                navController,
                uiState.latestNews
            )
            ButtonsLazyRow(
                modifier = Modifier
                    .padding(
                        top = 12.dp
                    )
                    .fillWidthOfParent(16.dp)
            )
            NewsLazyColumn(
                news = uiState.categoryNews
//                news = listOf(
//                    ColumnNews(
//                        "Amazon Big Spring Sale: 20 early deals from Apple, Sonos and Sony you can shop today",
//                        null,
//                        "Jeff Dunn,Valentina Palladino",
//                        "2024-03-19T07:00:36Z"
//                    ),
//                    ColumnNews(
//                        "IQ Air Atem X Review: High-End Air Purifier",
//                        "https://media.wired.com/photos/65f34b7c9f86ee0288b77ce4/191:100/w_1280,c_limit/IQAir-Atem-X-collage.jpg",
//                        "Lisa Wood Shapiro",
//                        "2024-03-21T14:30:00Z"
//                    ),
//                    ColumnNews(
//                        "PlayStation Network is partially down",
//                        "https://cdn.vox-cdn.com/thumbor/mzgzqR4AUblRBIw7ow2O66rkeeQ=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/23986616/acastro_STK097_02.jpg",
//                        "Sean Hollister",
//                        "2024-03-21T18:13:12Z"
//                    )
//                )
            )
        }
        else {
            NewsLazyColumn(
                news = listOf(
                    ColumnNews(
                        "Amazon Big Spring Sale: 20 early deals from Apple, Sonos and Sony you can shop today",
                        null,
                        "Jeff Dunn,Valentina Palladino",
                        "2024-03-19T07:00:36Z"
                    ),
                    ColumnNews(
                        "IQ Air Atem X Review: High-End Air Purifier",
                        "https://media.wired.com/photos/65f34b7c9f86ee0288b77ce4/191:100/w_1280,c_limit/IQAir-Atem-X-collage.jpg",
                        "Lisa Wood Shapiro",
                        "2024-03-21T14:30:00Z"
                    ),
                    ColumnNews(
                        "PlayStation Network is partially down",
                        "https://cdn.vox-cdn.com/thumbor/mzgzqR4AUblRBIw7ow2O66rkeeQ=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/23986616/acastro_STK097_02.jpg",
                        "Sean Hollister",
                        "2024-03-21T18:13:12Z"
                    )
                )
            )
        }
    }
}

//@Preview
//@Composable
//fun PreviewFeedsScreen() {
//    FeedsScreen(rememberNavController())
//}

@Composable
fun LatestNewsLabel(modifier: Modifier) {
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