package com.emrekose.valorantguide.features.weapons.detail.domain.model

import com.emrekose.valorantguide.data.model.weapons.detail.ShopData
import com.emrekose.valorantguide.data.model.weapons.detail.Skin
import com.emrekose.valorantguide.data.model.weapons.detail.WeaponStats

data class WeaponDetailUiModel(
    val displayIcon: String?,
    val displayName: String?,
    val skins: List<Skin?>?,
    val shopData: ShopData?,
    val uuid: String?,
    val weaponStats: WeaponStats?
)
