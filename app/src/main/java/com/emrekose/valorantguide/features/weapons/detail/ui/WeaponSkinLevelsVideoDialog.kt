package com.emrekose.valorantguide.features.weapons.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri
import com.emrekose.valorantguide.ui.components.VideoPlayer

@Composable
fun WeaponSkinLevelsVideoDialog(setShowDialog: (Boolean) -> Unit, url: String?) {
    Dialog(
        onDismissRequest = { setShowDialog(false) },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VideoPlayer(uri = url.orEmpty().toUri())
            Button(
                onClick = { setShowDialog(false) },
            ) {
                Text(text = "Close")
            }
        }
    }
}