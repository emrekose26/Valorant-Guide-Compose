package com.emrekose.valorantguide.features.agents.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.agents.domain.mapper.AgentsMapper
import com.emrekose.valorantguide.features.agents.domain.model.AgentsUiModel
import com.emrekose.valorantguide.features.agents.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentsUseCase @Inject constructor(
    private val repository: AgentsRepository,
    private val mapper: AgentsMapper
) {

    suspend fun getAgents(): Flow<Result<List<AgentsUiModel>?>> {
        return repository.getAgents().map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}