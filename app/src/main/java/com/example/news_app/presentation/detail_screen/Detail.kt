package com.example.news_app.presentation.detail_screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.news_app.R

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavController
) {

    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        viewModel.checkCurrentLikedState()
        navController.navigateUp()
    }

//    val detailNews = DetailNews(
//        "Shohei Ohtani says he never participated in any sports gambling and accuses interpreter of ‘stealing money’ - CNN",
//        null,
//        "Raja Razek, Homero De la Fuente, Steve Almasy, Dalia Faheid, Elizabeth Wolfe",
//        "2024-03-25T22:13:25Z",
//        "Shohei Ohtani says he never participated in any sports gambling and accuses interpreter of ‘stealing money’CNN Live updates: Shohei Ohtani says he never gambled on sportsCNN Dodgers star Shohei Ohtani says he never bet on sports and interpreter Ippei Mizuhara…"
//    )

    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
        ) {
            AsyncImage(
                model = "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg",
                contentDescription = null,
                modifier = Modifier
                    .height(340.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Text(
                text = uiState.news.description,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        top = 130.dp
                    )
            )
        }
        ArrowBack(
            modifier = Modifier
                .size(
                    50.dp,
                    50.dp
                )
                .align(Alignment.TopStart)
                .padding(
                    start = 16.dp,
                    top = 16.dp
                )
                .background(
                    colorResource(R.color.gray_light),
                    RoundedCornerShape(12.dp)
                ),
            navController
        )
        Like(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .align(Alignment.BottomEnd)
                .padding(
                    end = 20.dp,
                    bottom = 20.dp
                )
                .background(
                    colorResource(R.color.gray_bn),
                    shape = RoundedCornerShape(30.dp)
                )
                .shadow(4.dp, shape = RoundedCornerShape(30.dp)),
            uiState.isFavorite,
            viewModel
        )
        Title(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 32.dp,
                    top = 250.dp,
                    end = 32.dp
                )
                .background(
                    color = colorResource(R.color.gray_light),
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.TopCenter),
            uiState.news.publishedAt,
            uiState.news.title,
            uiState.news.author
        )
    }
}

@Composable
fun ArrowBack(
    modifier: Modifier,
    navController: NavController
) {
    IconButton(
        onClick = {
            navController.popBackStack()
        },
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier
        )
    }
}

@Composable
fun Like(
    modifier: Modifier,
    isFavorite: Boolean,
    viewModel: DetailViewModel
) {
    Surface(
        modifier = modifier
    ) {
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = {
                viewModel.postUiEvent(DetailUiEvent.LikeClick(it))
                Log.d("like", "in viewModel: ${viewModel.uiState.value.isFavorite}")
                Log.d("like", "in uiState: ${viewModel.uiState.value.isFavorite}")
            }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite
                else Icons.Filled.FavoriteBorder,
                contentDescription = null,
                tint = if (isFavorite) colorResource(R.color.primary)
                else colorResource(R.color.gray_bn),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        6.dp
                    )
            )
        }
    }
}

@Composable
fun Title(
    modifier: Modifier,
    publishedAt: String,
    title: String,
    author: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = publishedAt,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp
                ),
            fontSize = 13.sp
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp
                ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Published by $author",
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 12.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 14.sp
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDetailScreen() {
//    DetailScreen(rememberNavController())
//}