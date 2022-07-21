package com.emrekose.valorantguide.features.agents.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    suspend fun getAgents(): Flow<Result<AgentsResponse?>>
}