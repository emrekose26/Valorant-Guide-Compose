package com.emrekose.valorantguide.features.maps.listing.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import com.emrekose.valorantguide.features.maps.listing.domain.model.MapsUiModel
import javax.inject.Inject

class MapsMapper @Inject constructor()
    : Mapper<MapsResponse?, List<MapsUiModel>?> {

    override fun mapFrom(from: MapsResponse?): List<MapsUiModel>? {
        return from?.mapsData?.map { map ->
            MapsUiModel(
                displayName = map?.displayName,
                listViewIcon = map?.listViewIcon,
                uuid = map?.uuid
            )
        }
    }
}