package com.emrekose.valorantguide.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emrekose.valorantguide.R
import com.emrekose.valorantguide.common.extensions.EMPTY
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme

@Composable
fun ErrorView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            Icons.Default.Warning,
            contentDescription = String.EMPTY,
            tint = Color.Red,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = stringResource(id = R.string.generic_error),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorViewPreview() {
    ValorantGuideTheme {
        ErrorView()
    }
}