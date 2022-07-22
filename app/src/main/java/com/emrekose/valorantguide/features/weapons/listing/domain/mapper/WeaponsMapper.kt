package com.emrekose.valorantguide.features.weapons.listing.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import com.emrekose.valorantguide.features.weapons.listing.domain.model.WeaponsUiModel
import javax.inject.Inject

class WeaponsMapper @Inject constructor() : Mapper<WeaponsResponse?, List<WeaponsUiModel>?> {

    override fun mapFrom(from: WeaponsResponse?): List<WeaponsUiModel>? {
        return from?.weaponsData?.map {
            WeaponsUiModel(
                displayName = it?.displayName,
                displayIcon = it?.displayIcon,
                uuid = it?.uuid
            )
        }
    }
}