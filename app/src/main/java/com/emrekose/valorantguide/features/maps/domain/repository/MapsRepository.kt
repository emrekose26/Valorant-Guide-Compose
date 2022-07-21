package com.emrekose.valorantguide.features.maps.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import kotlinx.coroutines.flow.Flow

interface MapsRepository {
    suspend fun getMaps(): Flow<Result<MapsResponse?>>
}