package com.emrekose.valorantguide.features.maps.detail.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.maps.detail.MapDetailResponse
import com.emrekose.valorantguide.features.maps.detail.domain.model.MapDetailUiModel
import javax.inject.Inject

class MapDetailMapper @Inject constructor()
    :Mapper<MapDetailResponse?, MapDetailUiModel?>  {

    override fun mapFrom(from: MapDetailResponse?): MapDetailUiModel? {
        return MapDetailUiModel(
            coordinates = from?.mapDetailData?.coordinates,
            displayIcon = from?.mapDetailData?.displayIcon,
            displayName = from?.mapDetailData?.displayName,
            splash = from?.mapDetailData?.splash
        )
    }
}