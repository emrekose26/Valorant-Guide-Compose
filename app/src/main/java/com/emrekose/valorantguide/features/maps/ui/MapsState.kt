package com.emrekose.valorantguide.features.maps.ui

import com.emrekose.valorantguide.features.maps.domain.model.MapsUiModel

data class MapsState(
    val isLoading: Boolean = false,
    val maps: List<MapsUiModel>? = emptyList(),
    val error: String? = null
)
