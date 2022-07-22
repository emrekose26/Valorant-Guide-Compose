package com.emrekose.valorantguide.features.agents.listing.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.emrekose.valorantguide.R
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.agents.AgentRole
import com.emrekose.valorantguide.features.agents.listing.domain.model.AgentsUiModel
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
                    model = item.bustPortrait,
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxSize()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(
                            id = getImageResIdByRole(item.role?.displayName)
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = item.role?.displayName.orEmpty(),
                        fontSize = 11.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(text = item.displayName.orEmpty(), fontSize = 25.sp, color = Color.White)
            }
        }
    }
}

private fun getImageResIdByRole(role: String?): Int {
    return when (role) {
        AgentRole.Initiator.name -> R.drawable.ic_initiator
        AgentRole.Duelist.name -> R.drawable.ic_duelist
        AgentRole.Sentinel.name -> R.drawable.ic_sentinel
        AgentRole.Controller.name -> R.drawable.ic_controller
        else -> R.drawable.ic_duelist
    }
}

