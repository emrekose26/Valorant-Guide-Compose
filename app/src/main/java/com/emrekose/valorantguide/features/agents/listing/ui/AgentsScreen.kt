package com.emrekose.valorantguide.features.agents.listing.ui

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
import com.emrekose.valorantguide.features.agents.listing.ui.components.AgentItem
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.navigation.ScreenType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentsScreen(
    navController: NavController,
    viewModel: AgentsViewModel = hiltViewModel()
) {
    val pageState = viewModel.state.value

    Column(modifier = Modifier.background(Color.Black)) {
        if (pageState.isLoading) {
            ValorantGuideProgressBar()
        }

        if (!pageState.agents.isNullOrEmpty()) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2)
            ) {
                items(pageState.agents) { agent ->
                    AgentItem(item = agent, onItemClick = {
                        navController.navigate(
                            "${ScreenType.AgentDetail.route}/${agent.uuid}"
                        )
                    })
                }
            }
        }

        if (!pageState.error.isNullOrEmpty()) {
            ErrorView()
        }
    }
}