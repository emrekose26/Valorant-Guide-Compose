package com.emrekose.valorantguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.emrekose.valorantguide.ui.navigation.BottomNavBar
import com.emrekose.valorantguide.ui.navigation.Navigation
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme

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
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Valorant Guide") }
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) {
        Navigation(navController)
    }
}
