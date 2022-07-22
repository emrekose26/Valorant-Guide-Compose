package com.emrekose.valorantguide.features.weapons.listing.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.weapons.listing.domain.mapper.WeaponsMapper
import com.emrekose.valorantguide.features.weapons.listing.domain.model.WeaponsUiModel
import com.emrekose.valorantguide.features.weapons.listing.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeaponsUseCase @Inject constructor(
    private val repository: WeaponsRepository,
    private val mapper: WeaponsMapper
){

    suspend fun getWeapons(): Flow<Result<List<WeaponsUiModel>?>> {
        return repository.getWeapons().map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}