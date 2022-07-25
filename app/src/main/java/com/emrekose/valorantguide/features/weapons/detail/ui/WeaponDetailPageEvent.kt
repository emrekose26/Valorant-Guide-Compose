package com.emrekose.valorantguide.features.weapons.detail.ui

import com.emrekose.valorantguide.data.model.weapons.detail.Level
import com.emrekose.valorantguide.data.model.weapons.detail.Skin

sealed class WeaponDetailPageEvent {
    data class OnSkinItemClick(val skin: Skin?): WeaponDetailPageEvent()
    data class OnVideoShow(val level: Level?): WeaponDetailPageEvent()
}
