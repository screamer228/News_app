package com.example.news_app.presentation.search_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news_app.R

@Composable
fun SearchBar(modifier: Modifier) {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState,
        onValueChange = { value -> textState = value },
        modifier = modifier,
        leadingIcon = {
            Icon(
                painterResource(R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
            )
        },
        placeholder = {
            Text(
                stringResource(R.string.search),
                modifier = Modifier
                    .padding(
                        vertical = 2.dp
                    ),
                fontSize = 14.sp,
                color = colorResource(R.color.gray_hard)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.gray_light),
            unfocusedContainerColor = colorResource(R.color.gray_light),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = colorResource(R.color.gray_hard),
            unfocusedLeadingIconColor = colorResource(R.color.gray_hard),
            unfocusedSupportingTextColor = colorResource(R.color.gray_hard),
        ),
        singleLine = true,
        shape = RoundedCornerShape(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    SearchBar(Modifier)
}