package com.emrekose.valorantguide.features.agents.listing.ui

import com.emrekose.valorantguide.features.agents.listing.domain.model.AgentsUiModel

data class AgentsState(
    val isLoading: Boolean = false,
    val agents: List<AgentsUiModel>? = emptyList(),
    val error: String? = null
)
