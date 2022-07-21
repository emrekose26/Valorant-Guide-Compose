package com.emrekose.valorantguide.features.maps.detail.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.maps.detail.domain.mapper.MapDetailMapper
import com.emrekose.valorantguide.features.maps.detail.domain.model.MapDetailUiModel
import com.emrekose.valorantguide.features.maps.listing.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MapDetailUseCase @Inject constructor(
    private val repository: MapsRepository,
    private val mapper: MapDetailMapper
) {

    suspend fun getMapDetail(mapUuid: String): Flow<Result<MapDetailUiModel?>> {
        return repository.getMapDetail(mapUuid).map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}