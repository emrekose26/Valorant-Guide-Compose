package com.emrekose.valorantguide.data.model.maps.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MapDetailResponse(
    @Json(name = "data")
    val mapDetailData: Data?,
    @Json(name = "status")
    val status: Int?
)