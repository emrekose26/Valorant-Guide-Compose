package com.emrekose.valorantguide.features.weapons.detail.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.weapons.detail.WeaponDetailResponse
import com.emrekose.valorantguide.features.weapons.detail.domain.model.WeaponDetailUiModel
import javax.inject.Inject

class WeaponDetailMapper @Inject constructor() :
    Mapper<WeaponDetailResponse?, WeaponDetailUiModel> {

    override fun mapFrom(from: WeaponDetailResponse?): WeaponDetailUiModel {
        return WeaponDetailUiModel(
            displayIcon = from?.weaponDetails?.displayIcon,
            displayName = from?.weaponDetails?.displayName,
            skins = from?.weaponDetails?.skins,
            shopData = from?.weaponDetails?.shopData,
            uuid = from?.weaponDetails?.uuid,
            weaponStats = from?.weaponDetails?.weaponStats
        )
    }

}