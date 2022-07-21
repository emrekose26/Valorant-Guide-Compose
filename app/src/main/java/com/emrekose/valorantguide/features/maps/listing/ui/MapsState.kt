package com.emrekose.valorantguide.features.maps.listing.ui

import com.emrekose.valorantguide.features.maps.listing.domain.model.MapsUiModel

data class MapsState(
    val isLoading: Boolean = false,
    val maps: List<MapsUiModel>? = emptyList(),
    val error: String? = null
)
