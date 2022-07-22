package com.emrekose.valorantguide.data.model.agents.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VoiceLine(
    @Json(name = "maxDuration")
    val maxDuration: Double?,
    @Json(name = "mediaList")
    val mediaList: List<Media?>?,
    @Json(name = "minDuration")
    val minDuration: Double?
)