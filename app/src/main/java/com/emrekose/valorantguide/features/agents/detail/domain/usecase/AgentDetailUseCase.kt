package com.emrekose.valorantguide.features.agents.detail.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.agents.detail.domain.mapper.AgentDetailMapper
import com.emrekose.valorantguide.features.agents.detail.domain.model.AgentDetailUiModel
import com.emrekose.valorantguide.features.agents.listing.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentDetailUseCase @Inject constructor(
    private val repository: AgentsRepository,
    private val mapper: AgentDetailMapper
) {

    suspend fun getAgentDetail(agentUuid: String): Flow<Result<AgentDetailUiModel?>> {
        return repository.getAgentDetail(agentUuid).map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}