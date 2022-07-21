package com.emrekose.valorantguide.data.model.maps.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "x")
    val x: Double?,
    @Json(name = "y")
    val y: Double?
)