package com.emrekose.valorantguide.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.common.extensions.orZero

@Composable
fun BottomNavBar(navHostController: NavHostController) {
    val items = listOf(
        ScreenType.Agents,
        ScreenType.Maps,
        ScreenType.Weapons
    )
    Column {
        BottomNavigation {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { screen ->
                BottomNavigationItem(
                    onClick = {
                        // to make sure that we do not on the same screen again and again
                        if (currentRoute?.contains(screen.route) == false) {
                            // removed backstack when navigated
                            navHostController.popBackStack(
                                navHostController.graph.startDestinationId,
                                false
                            )

                            when (screen.route) {
                                ScreenType.Agents.route -> {
                                    navHostController.navigate(screen.route) {
                                        launchSingleTop = true
                                    }
                                }
                                ScreenType.Maps.route -> {
                                    navHostController.navigate(screen.route) {
                                        launchSingleTop = true
                                    }
                                }
                                ScreenType.Weapons.route -> {
                                    navHostController.navigate(screen.route) {
                                        launchSingleTop = true
                                    }
                                }
                            }
                        }
                    },
                    icon = { Icon(painterResource(id = screen.icon.orZero()), contentDescription = "") },
                    label = { Text(text = screen.name.orEmpty()) },
                    selected = currentRoute == screen.route
                )
            }
        }
    }
}