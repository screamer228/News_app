package com.example.news_app.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

fun Modifier.fillWidthOfParent(parentPadding: Dp) = this.then(
    layout { measurable, constraints ->
        // This is to force layout to go beyond the borders of its parent
        val placeable = measurable.measure(
            constraints.copy(
                maxWidth = constraints.maxWidth + 2 * parentPadding.roundToPx(),
            ),
        )
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    },
)

data class Paddings(
    val paddingStart: Int,
    val paddingEnd: Int
)

fun buttonPaddings(index: Int, itemCount: Int): Paddings {
    val paddingStart = itemLazyRowPadding(index)

    val paddingEnd = if (index == (itemCount - 1)) 16
    else 0

    return Paddings(paddingStart, paddingEnd)
}

fun itemLazyRowPadding(index: Int): Int {
    return if (index == 0) 16
    else 0
}