package com.emrekose.valorantguide.features.agents.detail.ui

import com.emrekose.valorantguide.features.agents.detail.domain.model.AgentDetailUiModel

data class AgentDetailState(
    val isLoading: Boolean = false,
    val agentDetails: AgentDetailUiModel? = null,
    val error: String? = null
)
