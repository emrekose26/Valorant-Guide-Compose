package com.emrekose.valorantguide.features.agents.detail.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.emrekose.valorantguide.R
import com.emrekose.valorantguide.common.extensions.isNotNull
import com.emrekose.valorantguide.common.extensions.orEmpty
import com.emrekose.valorantguide.data.model.agents.detail.Ability
import com.emrekose.valorantguide.features.agents.AgentRole
import com.emrekose.valorantguide.features.agents.detail.domain.model.AgentDetailUiModel
import com.emrekose.valorantguide.ui.components.ErrorView
import com.emrekose.valorantguide.ui.components.ValorantGuideProgressBar
import com.emrekose.valorantguide.ui.theme.DarkBlue
import com.emrekose.valorantguide.ui.theme.RedOrange
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun AgentDetailScreen(
    viewModel: AgentDetailViewModel = hiltViewModel()
) {
    val pageState = viewModel.state.value

    if (pageState.isLoading)
        ValorantGuideProgressBar()

    if (pageState.agentDetails.isNotNull())
        Content(pageState.agentDetails)

    if (!pageState.error.isNullOrEmpty())
        ErrorView()
}

@Composable
private fun Content(agentDetails: AgentDetailUiModel?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = agentDetails?.displayName.orEmpty(),
            color = RedOrange,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkBlue)
                .height(50.dp)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(modifier = Modifier.weight(2f)) {
                AsyncImage(
                    model = agentDetails?.background,
                    contentDescription = null,
                    alpha = 0.3f,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(320.dp)
                )
                AsyncImage(
                    model = agentDetails?.fullPortraitV2,
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(320.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(text = "// Role", color = RedOrange)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(
                            id = getImageResIdByRole(agentDetails?.role?.displayName)
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = agentDetails?.role?.displayName.orEmpty(),
                        fontSize = 26.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "// Biography", color = RedOrange)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    color = Color.White,
                    text = agentDetails?.description.orEmpty(),
                    style = MaterialTheme.typography.h2
                )
            }
        }
        AbilityTabView(abilities = agentDetails?.abilities)
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AbilityTabView(abilities: List<Ability?>?) {

    val tabData = arrayListOf<Pair<String?, String?>>()
    abilities?.map { ability ->
        if (!ability?.description.isNullOrEmpty() &&
            !ability?.displayIcon.isNullOrEmpty()
        )
            tabData.add(Pair(ability?.description, ability?.displayIcon))
    }

    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = RedOrange,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, icon = {
                    AsyncImage(
                        model = pair.second,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                })
            }
        }

        HorizontalPager(
            state = pagerState,
        ) { index ->
            PagerViewContent(tabData[index].first.orEmpty())
        }
    }
}

@Composable
fun PagerViewContent(content: String) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(DarkBlue)
    ) {
        Text(
            text = content,
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ContentPreview() {
    ValorantGuideTheme() {
        Content(agentDetails = null)
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