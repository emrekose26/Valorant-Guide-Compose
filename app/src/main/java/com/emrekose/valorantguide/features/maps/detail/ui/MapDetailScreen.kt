package com.emrekose.valorantguide.features.maps.detail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.emrekose.valorantguide.common.extensions.isNotNull
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.maps.detail.domain.model.MapDetailUiModel
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar

@Composable
fun MapDetailScreen(
    viewModel: MapDetailViewModel = hiltViewModel()
) {
    val pageState = viewModel.state.value

    if (pageState.isLoading)
        ValorantGuideProgressBar()

    if (pageState.mapDetails.isNotNull())
        Content(pageState.mapDetails)

    if (!pageState.error.isNullOrEmpty())
        ErrorView()
}

@Composable
private fun Content(details: MapDetailUiModel?) {
    Box {
        AsyncImage(
            model = details?.splash,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8f,
            modifier = Modifier
                .fillMaxSize()
        )

        Column {
            Text(
                text = details?.displayName.orEmpty(),
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = details?.coordinates.orEmpty(),
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = details?.displayIcon,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}