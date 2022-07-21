package com.emrekose.valorantguide.features.agents.ui

import android.util.Log
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
import com.emrekose.valorantguide.features.agents.ui.components.AgentItem
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentsScreen(
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
                        Log.e("Agent", "AgentsScreen: ${it.displayName}")
                    })
                }
            }
        }

        if (!pageState.error.isNullOrEmpty()) {
            ErrorView()
        }
    }
}