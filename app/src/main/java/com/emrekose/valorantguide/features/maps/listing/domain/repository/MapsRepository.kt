package com.emrekose.valorantguide.features.maps.listing.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import com.emrekose.valorantguide.data.model.maps.detail.MapDetailResponse
import kotlinx.coroutines.flow.Flow

interface MapsRepository {
    suspend fun getMaps(): Flow<Result<MapsResponse?>>
    suspend fun getMapDetail(mapUuid: String): Flow<Result<MapDetailResponse?>>
}