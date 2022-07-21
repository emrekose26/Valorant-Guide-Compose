package com.emrekose.valorantguide.features.agents.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.agents.domain.model.AgentsUiModel
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.theme.Mandy

@Composable
fun AgentItem(
    item: AgentsUiModel,
    onItemClick: (AgentsUiModel) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(
                color = Mandy,
                shape = RoundedCornerShape(10.dp)
            )
            .height(200.dp)
            .clickable { onItemClick(item) }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            SubcomposeAsyncImage(
                model = item.background,
                contentDescription = null,
                loading = { ValorantGuideProgressBar() },
                contentScale = ContentScale.FillWidth,
                alpha = 0.1f,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                AsyncImage(
                    model = item.fullPortraitV2,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxSize()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.role?.displayName.orEmpty(), fontSize = 12.sp, color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = item.displayName.orEmpty(), fontSize = 25.sp, color = Color.White)
            }
        }
    }
}

