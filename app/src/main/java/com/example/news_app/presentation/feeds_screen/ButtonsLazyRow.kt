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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news_app.R
import com.example.news_app.presentation.feeds_screen.uistate.ButtonCategory
import com.example.news_app.presentation.feeds_screen.uistate.FeedsUiEvent
import com.example.news_app.presentation.feeds_screen.viewmodel.FeedsViewModel
import com.example.news_app.utils.lazyRowPaddings

@Composable
fun ButtonsLazyRow(
    modifier: Modifier,
    viewModel: FeedsViewModel
) {
    val buttons = listOf(
        ButtonCategory.Healthy,
        ButtonCategory.Technology,
        ButtonCategory.Business,
        ButtonCategory.Science,
        ButtonCategory.Sports
    )
    var selectedButtonIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        itemsIndexed(buttons) { index, item ->

            val paddings = lazyRowPaddings(index, buttons.size)

            FilledTonalButton(
                onClick = {
                    selectedButtonIndex = index
                    viewModel.postUiEvent(
                        FeedsUiEvent.ButtonCategoryClick(item.category)
                    )
                },
                modifier = Modifier
                    .padding(
                        start = paddings.paddingStart.dp,
                        end = paddings.paddingEnd.dp
                    )
                    .selectable(
                        selected = index == selectedButtonIndex,
                        onClick = {
                            selectedButtonIndex = index
                        }
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
                    text = stringResource(item.labelId),
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