package com.emrekose.valorantguide.features.agents.listing.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import com.emrekose.valorantguide.data.model.agents.detail.AgentDetailResponse
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    suspend fun getAgents(): Flow<Result<AgentsResponse?>>
    suspend fun getAgentDetail(agentUuid: String): Flow<Result<AgentDetailResponse?>>
}