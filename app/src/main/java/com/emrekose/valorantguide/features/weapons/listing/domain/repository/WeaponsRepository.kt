package com.emrekose.valorantguide.features.weapons.listing.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import com.emrekose.valorantguide.data.model.weapons.detail.WeaponDetailResponse
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {
    suspend fun getWeapons(): Flow<Result<WeaponsResponse?>>
    suspend fun getWeaponDetail(weaponUuid: String): Flow<Result<WeaponDetailResponse?>>
}