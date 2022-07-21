package com.emrekose.valorantguide.data.model.weapons


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AltShotgunStats(
    @Json(name = "burstRate")
    val burstRate: Double?,
    @Json(name = "shotgunPelletCount")
    val shotgunPelletCount: Int?
)