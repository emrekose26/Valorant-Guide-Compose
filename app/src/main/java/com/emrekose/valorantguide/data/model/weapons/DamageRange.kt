package com.emrekose.valorantguide.data.model.weapons


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DamageRange(
    @Json(name = "bodyDamage")
    val bodyDamage: Int?,
    @Json(name = "headDamage")
    val headDamage: Double?,
    @Json(name = "legDamage")
    val legDamage: Double?,
    @Json(name = "rangeEndMeters")
    val rangeEndMeters: Int?,
    @Json(name = "rangeStartMeters")
    val rangeStartMeters: Int?
)