package com.emrekose.valorantguide.features.weapons.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.emrekose.valorantguide.common.extensions.isNotNull
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.data.model.weapons.detail.Level
import com.emrekose.valorantguide.data.model.weapons.detail.Skin
import com.emrekose.valorantguide.features.weapons.detail.domain.model.WeaponDetailUiModel
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.theme.DarkBlue
import com.emrekose.valorantguide.ui.theme.RedOrange
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme

@Composable
fun WeaponDetailScreen(
    viewModel: WeaponDetailViewModel = hiltViewModel()
) {
    val pageState = viewModel.state.value
    var openDialog by remember { mutableStateOf(false) }

    if (pageState.isLoading)
        ValorantGuideProgressBar()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (pageState.weaponDetails.isNotNull()) {
            WeaponInfo(pageState.weaponDetails, onSkinItemClick = { skin ->
                viewModel.onEvent(WeaponDetailPageEvent.OnSkinItemClick(skin))
            })
        }

        if (pageState.skinDetails.isNotNull()) {
            Text(text = "Levels")
            SkinInfo(pageState.skinDetails, videoShowListener = { level ->
                viewModel.onEvent(WeaponDetailPageEvent.OnVideoShow(level))
                openDialog = true
            })
        }

        if (pageState.levelDetails.isNotNull()) {
            if (openDialog) {
                WeaponSkinLevelsVideoDialog(
                    setShowDialog = { openDialog = it },
                    pageState.levelDetails?.streamedVideo
                )
            }
        }
    }

    if (!pageState.error.isNullOrEmpty())
        ErrorView()
}

@Composable
private fun WeaponInfo(
    weaponDetails: WeaponDetailUiModel?,
    onSkinItemClick: (Skin?) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(DarkBlue)
        ) {
            Text(
                text = weaponDetails?.displayName.orEmpty(),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(8.dp)
            )
            AsyncImage(
                model = weaponDetails?.displayIcon,
                contentDescription = null,
                modifier = Modifier
                    .padding(24.dp)
                    .height(100.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(DarkBlue)
        ) {

            StatCell(
                Pair("Cost: ", weaponDetails?.shopData?.cost.toString()),
                Pair("Fire Rate: ", weaponDetails?.weaponStats?.fireRate.toString())
            )
            StatCell(
                Pair("Magazine Size: ", weaponDetails?.weaponStats?.magazineSize.toString()),
                Pair("Reload Time: ", "${weaponDetails?.weaponStats?.reloadTimeSeconds} sec")
            )
        }

        SkinsList(weaponDetails?.skins, onSkinItemClick)
    }
}

@Composable
private fun StatCell(
    firsCellData: Pair<String, String>,
    secondCellData: Pair<String, String>
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = firsCellData.first,
                color = RedOrange,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.alignByBaseline()
            )
            Text(
                text = firsCellData.second,
                color = Color.White,
                modifier = Modifier.alignByBaseline()
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = secondCellData.first,
                color = RedOrange,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.alignByBaseline()
            )
            Text(
                text = secondCellData.second, color = Color.White,
                modifier = Modifier.alignByBaseline()
            )
        }
    }
}

@Composable
private fun SkinsList(skins: List<Skin?>?, onSkinItemClick: (Skin?) -> Unit) {
    LazyRow(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(DarkBlue)

    ) {
        items(skins.orEmpty()) { skin ->
            SkinItem(skin, onItemClick = {
                onSkinItemClick(it)
            })
        }
    }
}

@Composable
fun SkinItem(
    skin: Skin?,
    onItemClick: (Skin?) -> Unit
) {
    Box(
        modifier = Modifier.clickable {
            onItemClick(skin)
        }
    ) {
        AsyncImage(
            model = skin?.displayIcon,
            contentDescription = null,
            modifier = Modifier
                .height(70.dp)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun SkinInfo(skin: Skin?, videoShowListener: (Level?) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(DarkBlue)
    ) {
        Text(
            text = "Levels",
            fontSize = 18.sp,
            color = RedOrange,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(contentPadding = PaddingValues(8.dp)) {
            items(skin?.levels.orEmpty()) { level ->
                Text(
                    color = Color.White,
                    text = "- ${level?.displayName.orEmpty()}",
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable {
                            videoShowListener(level)
                        }
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ContentPreview() {
    ValorantGuideTheme() {
        WeaponInfo(weaponDetails = null, onSkinItemClick = {})
    }
}
