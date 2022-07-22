package com.emrekose.valorantguide.features.weapons.listing.domain.repository

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {
    suspend fun getWeapons(): Flow<Result<WeaponsResponse?>>
}