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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.news_app.presentation.detail_screen.uistate.DetailUiEvent
import com.example.news_app.presentation.detail_screen.uistate.DetailUiState
import com.example.news_app.presentation.detail_screen.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavController,
    title: String
) {

    val uiState by viewModel.uiState.collectAsState()

//    var loading by remember { mutableStateOf(uiState.isLoading)

    LaunchedEffect(key1 = Unit) {
        viewModel.initData(title)
    }

    BackHandler {
        viewModel.checkCurrentLikedState()
        navController.navigateUp()
    }

    Surface {
        if (uiState.isLoading) {
            Log.d("imageTest", "while Loading: ${uiState.news.imageUrl}")
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        } else {
            Log.d("imageTest", "what put: ${uiState.news.imageUrl}")
            ShowContent(
                navController,
                uiState,
                viewModel
            )
        }
    }
}

@Composable
fun ShowContent(
    navController: NavController,
    detailItem: DetailUiState,
    viewModel: DetailViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = detailItem.news.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .height(340.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Text(
                text = detailItem.news.description,
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
            detailItem.isFavorite,
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
            detailItem.news.publishedAt,
            detailItem.news.title,
            detailItem.news.author
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
            text = "$PUBLISHED_BY $author",
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

const val PUBLISHED_BY = "Published by"