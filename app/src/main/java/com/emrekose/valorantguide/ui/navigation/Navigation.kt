package com.emrekose.valorantguide.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emrekose.valorantguide.features.agents.ui.AgentsScreen
import com.emrekose.valorantguide.features.maps.ui.MapsScreen
import com.emrekose.valorantguide.features.weapons.ui.WeaponsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenType.Agents.route) {
        composable(ScreenType.Agents.route) {
            AgentsScreen()
        }

        composable(ScreenType.Maps.route) {
            MapsScreen()
        }

        composable(ScreenType.Weapons.route) {
            WeaponsScreen()
        }
    }
}