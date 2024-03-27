package com.example.news_app.presentation.detail_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.news_app.R
import com.example.news_app.model.DetailNews

@Composable
fun DetailScreen(
    navController: NavController
) {

    BackHandler {

    }

    val detailNews = DetailNews(
        "Shohei Ohtani says he never participated in any sports gambling and accuses interpreter of ‘stealing money’ - CNN",
        null,
        "Raja Razek, Homero De la Fuente, Steve Almasy, Dalia Faheid, Elizabeth Wolfe",
        "2024-03-25T22:13:25Z",
        "Shohei Ohtani says he never participated in any sports gambling and accuses interpreter of ‘stealing money’CNN Live updates: Shohei Ohtani says he never gambled on sportsCNN Dodgers star Shohei Ohtani says he never bet on sports and interpreter Ippei Mizuhara…"
    )

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
                text = detailNews.description,
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
                .clickable {
                    navController.popBackStack()
                }
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
                )
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
                .shadow(4.dp, shape = RoundedCornerShape(30.dp))
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
            detailNews.publishedAt,
            detailNews.title,
            detailNews.author
        )
    }
}

@Composable
fun ArrowBack(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
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
fun Like(modifier: Modifier) {
    Surface(
        modifier = modifier
    )
    {
        val checked = remember { mutableStateOf(false) }

        IconToggleButton(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }) {
            Icon(
                imageVector = if (checked.value) Icons.Filled.Favorite
                else Icons.Filled.FavoriteBorder,
                contentDescription = null,
                tint = if (checked.value) colorResource(R.color.primary)
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

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(rememberNavController())
}