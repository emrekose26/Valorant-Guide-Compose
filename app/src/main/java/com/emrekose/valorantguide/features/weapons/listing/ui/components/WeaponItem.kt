package com.emrekose.valorantguide.features.weapons.listing.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.features.weapons.listing.domain.model.WeaponsUiModel
import com.emrekose.valorantguide.ui.theme.Mandy

@Composable
fun WeaponItem(
    item: WeaponsUiModel?,
    onItemClick: (WeaponsUiModel?) -> Unit
) {
    Card(
        backgroundColor = Mandy,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(8.dp)
            .clickable { onItemClick(item) }
    ) {
        Column {
            Text(
                color = Color.White,
                text = item?.displayName.orEmpty(),
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            AsyncImage(
                model = item?.displayIcon,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(80.dp)
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }
}