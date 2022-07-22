package com.emrekose.valorantguide.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emrekose.valorantguide.features.agents.detail.ui.AgentDetailScreen
import com.emrekose.valorantguide.features.agents.listing.ui.AgentsScreen
import com.emrekose.valorantguide.features.maps.detail.ui.MapDetailScreen
import com.emrekose.valorantguide.features.maps.listing.ui.MapsScreen
import com.emrekose.valorantguide.features.weapons.listing.ui.WeaponsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenType.Agents.route) {
        composable(ScreenType.Agents.route) {
            AgentsScreen(navController)
        }

        composable(ScreenType.Maps.route) {
            MapsScreen(navController)
        }

        composable(ScreenType.Weapons.route) {
            WeaponsScreen()
        }

        composable("${ScreenType.MapDetail.route}/{mapUuid}") {
            MapDetailScreen()
        }

        composable("${ScreenType.AgentDetail.route}/{agentUuid}") {
            AgentDetailScreen()
        }
    }
}