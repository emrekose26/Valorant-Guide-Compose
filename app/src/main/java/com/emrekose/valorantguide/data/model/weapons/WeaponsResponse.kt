package com.emrekose.valorantguide.data.model.weapons


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeaponsResponse(
    @Json(name = "data")
    val weaponsData: List<Data?>?,
    @Json(name = "status")
    val status: Int?
)