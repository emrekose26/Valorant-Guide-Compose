package com.emrekose.valorantguide.features.maps.listing.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.maps.listing.domain.model.MapsUiModel
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar

@Composable
fun MapItem(
    item: MapsUiModel,
    onItemClick: (MapsUiModel) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { onItemClick(item) }
    ) {
        SubcomposeAsyncImage(
            model = item.listViewIcon,
            contentDescription = null,
            alpha = 0.7f,
            loading = { ValorantGuideProgressBar() },
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(100.dp)
                .fillMaxSize()
        )
        Text(
            text = item.displayName.orEmpty(),
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}