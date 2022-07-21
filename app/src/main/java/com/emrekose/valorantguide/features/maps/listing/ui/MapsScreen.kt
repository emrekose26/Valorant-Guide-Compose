package com.emrekose.valorantguide.features.maps.listing.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.maps.listing.ui.components.MapItem
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.navigation.ScreenType

@Composable
fun MapsScreen(
    navController: NavController,
    viewModel: MapsViewModel = hiltViewModel()
) {
    val pageState = viewModel.state.value

    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        if (pageState.isLoading)
            ValorantGuideProgressBar()

        if (!pageState.maps.isNullOrEmpty()) {
            LazyColumn {
                items(
                    items = pageState.maps,
                    key = { it.uuid.orEmpty() }
                ) { map ->
                    MapItem(item = map, onItemClick = { map ->
                        navController.navigate(
                            "${ScreenType.MapDetail.route}/${map.uuid}"
                        )
                    })
                }
            }
        }

        if (!pageState.error.isNullOrEmpty())
            ErrorView()
    }
}