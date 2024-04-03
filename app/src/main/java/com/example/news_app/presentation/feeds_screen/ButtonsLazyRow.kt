package com.example.news_app.presentation.feeds_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news_app.R
import com.example.news_app.utils.lazyRowPaddings

@Composable
fun ButtonsLazyRow(modifier: Modifier) {
    val buttonLabels = listOf(
        stringResource(R.string.healthy),
        stringResource(R.string.technology),
        stringResource(R.string.business),
        stringResource(R.string.science),
        stringResource(R.string.sports)
    )
    var selectedButtonIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        itemsIndexed(buttonLabels) { index, text ->

            val paddings = lazyRowPaddings(index, buttonLabels.size)

            FilledTonalButton(
                onClick = { selectedButtonIndex = index },
                modifier = Modifier
                    .padding(
                        start = paddings.paddingStart.dp,
                        end = paddings.paddingEnd.dp
                    )
                    .selectable(
                        selected = index == selectedButtonIndex,
                        onClick = { selectedButtonIndex = index }
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (index == selectedButtonIndex)
                        colorResource(R.color.primary)
                    else
                        Color.Transparent
                ),
                shape = RoundedCornerShape(30.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(R.color.gray_light)
                ),
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                )
            )
            {
                Text(
                    text = text,
                    modifier = Modifier,
                    color = if (index == selectedButtonIndex) Color.White
                    else Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewButtonsLazyRow() {
    ButtonsLazyRow(Modifier)
}