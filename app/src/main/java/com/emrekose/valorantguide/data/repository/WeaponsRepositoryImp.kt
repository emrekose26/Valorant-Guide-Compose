package com.emrekose.valorantguide.data.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.base.BaseRepository
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import com.emrekose.valorantguide.data.model.weapons.detail.WeaponDetailResponse
import com.emrekose.valorantguide.data.remote.ApiService
import com.emrekose.valorantguide.features.weapons.listing.domain.repository.WeaponsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeaponsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
): BaseRepository(), WeaponsRepository {

    override suspend fun getWeapons(): Flow<Result<WeaponsResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getWeapons() }
    }

    override suspend fun getWeaponDetail(weaponUuid: String): Flow<Result<WeaponDetailResponse?>> {
        return safeApiCall(defaultDispatcher) { apiService.getWeaponDetail(weaponUuid) }
    }
}