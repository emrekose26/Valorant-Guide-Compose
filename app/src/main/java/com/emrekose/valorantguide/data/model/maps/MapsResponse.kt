package com.emrekose.valorantguide.data.model.maps


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MapsResponse(
    @Json(name = "data")
    val `data`: List<Data?>?,
    @Json(name = "status")
    val status: Int?
)