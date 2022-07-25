package com.emrekose.valorantguide.features.weapons.detail.domain.usecase

import com.emrekose.valorantguide.common.Result
import com.emrekose.valorantguide.common.map
import com.emrekose.valorantguide.features.weapons.detail.domain.mapper.WeaponDetailMapper
import com.emrekose.valorantguide.features.weapons.detail.domain.model.WeaponDetailUiModel
import com.emrekose.valorantguide.features.weapons.listing.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class WeaponDetailUseCase @Inject constructor(
    private val repository: WeaponsRepository,
    private val mapper: WeaponDetailMapper
) {

    suspend fun getWeaponDetail(weaponUuid: String): Flow<Result<WeaponDetailUiModel?>> {
        return repository.getWeaponDetail(weaponUuid).map { result ->
            result.map { response ->
                mapper.mapFrom(response)
            }
        }
    }
}