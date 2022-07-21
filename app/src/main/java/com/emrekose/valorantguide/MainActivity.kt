package com.emrekose.valorantguide

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.emrekose.valorantguide.ui.navigation.BottomNavBar
import com.emrekose.valorantguide.ui.navigation.Navigation
import com.emrekose.valorantguide.ui.navigation.ScreenType
import com.emrekose.valorantguide.ui.theme.ValorantFont
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
            TopAppBar(
                title = { Text(text = getToolbarTitle(context, currentRoute), fontFamily = ValorantFont) },
                navigationIcon = if (currentRoute == "${ScreenType.MapDetail.route}/{mapUuid}"){
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                } else null
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
        ScreenType.Maps.route -> R.string.maps
        "${ScreenType.MapDetail.route}/{mapUuid}" -> R.string.map_detail
        ScreenType.Weapons.route -> R.string.weapons
        else -> R.string.app_name
    }
    return context.getString(titleResId)
}
