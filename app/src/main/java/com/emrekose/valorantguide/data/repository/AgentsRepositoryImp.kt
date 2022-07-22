package com.emrekose.valorantguide.data.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.base.BaseRepository
import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import com.emrekose.valorantguide.data.model.agents.detail.AgentDetailResponse
import com.emrekose.valorantguide.data.remote.ApiService
import com.emrekose.valorantguide.features.agents.listing.domain.repository.AgentsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgentsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : BaseRepository(), AgentsRepository {

    override suspend fun getAgents(): Flow<Result<AgentsResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getAgents() }
    }

    override suspend fun getAgentDetail(agentUuid: String): Flow<Result<AgentDetailResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getAgentDetail(agentUuid) }
    }
}