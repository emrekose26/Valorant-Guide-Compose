package com.emrekose.valorantguide.data.model.maps.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Callout(
    @Json(name = "location")
    val location: Location?,
    @Json(name = "regionName")
    val regionName: String?,
    @Json(name = "superRegionName")
    val superRegionName: String?
)