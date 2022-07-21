package com.emrekose.valorantguide.features.agents.ui

import com.emrekose.valorantguide.features.agents.domain.model.AgentsUiModel

data class AgentsState(
    val isLoading: Boolean = false,
    val agents: List<AgentsUiModel>? = emptyList(),
    val error: String? = null
)
