package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdsStats(
    @Json(name = "burstCount")
    val burstCount: Int?,
    @Json(name = "fireRate")
    val fireRate: Double?,
    @Json(name = "firstBulletAccuracy")
    val firstBulletAccuracy: Double?,
    @Json(name = "runSpeedMultiplier")
    val runSpeedMultiplier: Double?,
    @Json(name = "zoomMultiplier")
    val zoomMultiplier: Double?
)