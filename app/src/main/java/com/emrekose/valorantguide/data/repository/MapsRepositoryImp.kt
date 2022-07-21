package com.emrekose.valorantguide.data.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.base.BaseRepository
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import com.emrekose.valorantguide.data.model.maps.detail.MapDetailResponse
import com.emrekose.valorantguide.data.remote.ApiService
import com.emrekose.valorantguide.features.maps.listing.domain.repository.MapsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MapsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : BaseRepository(), MapsRepository {

    override suspend fun getMaps(): Flow<Result<MapsResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getMaps() }
    }

    override suspend fun getMapDetail(mapUuid: String): Flow<Result<MapDetailResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getMapDetail(mapUuid) }
    }
}