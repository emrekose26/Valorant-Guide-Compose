package com.emrekose.valorantguide.features.weapons.listing.ui

import com.emrekose.valorantguide.features.weapons.listing.domain.model.WeaponsUiModel

data class WeaponsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val weapons: List<WeaponsUiModel>? = emptyList()
)