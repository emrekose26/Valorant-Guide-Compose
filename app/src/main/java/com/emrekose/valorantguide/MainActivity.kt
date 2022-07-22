package com.emrekose.valorantguide

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.emrekose.valorantguide.ui.components.ValorantGuideTopAppBar
import com.emrekose.valorantguide.ui.navigation.BottomNavBar
import com.emrekose.valorantguide.ui.navigation.Navigation
import com.emrekose.valorantguide.ui.navigation.ScreenType
import com.emrekose.valorantguide.ui.theme.DarkBlue
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantGuideTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            ValorantGuideTopAppBar(
                title = getToolbarTitle(context, currentRoute),
                backgroundColor = DarkBlue,
                contentColor = Color.White,
                isNavigationIconVisible = isNavigationIconVisible(currentRoute),
                onNavigationIconClick = {
                    navController.popBackStack()
                },
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            Navigation(navController)
        }
    }
}

private fun getToolbarTitle(context: Context, route: String?): String {
    val titleResId = when(route) {
        ScreenType.Agents.route -> R.string.agents
        "${ScreenType.AgentDetail.route}/{agentUuid}" -> R.string.agent_detail
        ScreenType.Maps.route -> R.string.maps
        "${ScreenType.MapDetail.route}/{mapUuid}" -> R.string.map_detail
        ScreenType.Weapons.route -> R.string.weapons
        else -> R.string.app_name
    }
    return context.getString(titleResId)
}

private fun isNavigationIconVisible(currentRoute: String?): Boolean {
    return when(currentRoute) {
        "${ScreenType.MapDetail.route}/{mapUuid}",
        "${ScreenType.AgentDetail.route}/{agentUuid}", -> true
        else -> false
    }
}
