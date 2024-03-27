package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.news_app.model.LatestNews
import com.example.news_app.utils.lazyRowPaddings

@Composable
fun LatestNewsLazyRow(
    modifier: Modifier,
    news: List<LatestNews>,
    navController: NavController
) {
    LazyRow(
        modifier = modifier
    ) {
        itemsIndexed(news) { index, item ->

            val paddings = lazyRowPaddings(index, news.size)

            Box(
                modifier = Modifier
                    .clickable {
                        navController.navigate("detail")
                    }
                    .height(200.dp)
                    .width(300.dp)
                    .padding(
                        start = paddings.paddingStart.dp,
                        end = paddings.paddingEnd.dp
                    )
                    .clip(RoundedCornerShape(8.dp))
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
                Text(
                    text = item.title,
                    modifier = Modifier
                        .align(
                            Alignment.BottomStart
                        )
                        .padding(
                            12.dp
                        ),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewLatestNewsLazyRow(){
//    LatestNewsLazyRow(Modifier)
//}