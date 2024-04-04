package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import coil.compose.AsyncImage
import com.example.news_app.presentation.model.ColumnNews

@Composable
fun NewsLazyColumn(
    news: List<ColumnNews>
) {
    LazyColumn(
        modifier = Modifier
            .padding(
                top = 8.dp
            ),
    ) {
        itemsIndexed(news) { index, item ->
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(
                        bottom = 12.dp
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
                            Alignment.TopStart
                        )
                        .padding(
                            vertical = 8.dp,
                            horizontal = 12.dp
                        ),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.author,
                    modifier = Modifier
                        .align(
                            Alignment.BottomStart
                        )
                        .padding(
                            vertical = 8.dp,
                            horizontal = 12.dp
                        ),
                    color = Color.White
                )
                Text(
                    text = item.publishedAt,
                    modifier = Modifier
                        .align(
                            Alignment.BottomEnd
                        )
                        .padding(
                            vertical = 8.dp,
                            horizontal = 12.dp
                        ),
                    color = Color.White
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