package com.emrekose.valorantguide.features.maps.detail.ui

import com.emrekose.valorantguide.features.maps.detail.domain.model.MapDetailUiModel

data class MapDetailState(
    val isLoading: Boolean = false,
    val mapDetails: MapDetailUiModel? = null,
    val error: String? = null
)
