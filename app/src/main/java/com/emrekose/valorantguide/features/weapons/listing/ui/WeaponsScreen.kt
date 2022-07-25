package com.emrekose.valorantguide.features.weapons.listing.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emrekose.valorantguide.features.weapons.listing.ui.components.WeaponItem
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.navigation.ScreenType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeaponsScreen(
    navController: NavController,
    viewModel: WeaponsViewModel = hiltViewModel()
) {

    val pageState = viewModel.state.value

    Column(
        modifier = Modifier.background(Color.Black)
    ) {
        if (pageState.isLoading)
            ValorantGuideProgressBar()

        if (!pageState.weapons.isNullOrEmpty()) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2)
            ) {
                items(pageState.weapons) { weapon ->
                    WeaponItem(item = weapon, onItemClick = {
                        navController.navigate(
                            "${ScreenType.WeaponDetail.route}/${weapon.uuid}"
                        )
                    })
                }
            }
        }

        if (!pageState.error.isNullOrEmpty())
            ErrorView()

    }
}
