package com.emrekose.valorantguide.features.weapons.detail.ui

import com.emrekose.valorantguide.data.model.weapons.detail.Level
import com.emrekose.valorantguide.data.model.weapons.detail.Skin
import com.emrekose.valorantguide.features.weapons.detail.domain.model.WeaponDetailUiModel

data class WeaponDetailState(
    val isLoading: Boolean = false,
    val weaponDetails: WeaponDetailUiModel? = null,
    val skinDetails: Skin? = null,
    val levelDetails: Level? = null,
    val error: String? = null
)
