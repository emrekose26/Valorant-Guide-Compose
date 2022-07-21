package com.emrekose.valorantguide.features.maps.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.maps.domain.mapper.MapsMapper
import com.emrekose.valorantguide.features.maps.domain.model.MapsUiModel
import com.emrekose.valorantguide.features.maps.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MapsUseCase @Inject constructor(
    private val repository: MapsRepository,
    private val mapper: MapsMapper
) {

    suspend fun getMaps(): Flow<Result<List<MapsUiModel>?>> {
        return repository.getMaps().map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}