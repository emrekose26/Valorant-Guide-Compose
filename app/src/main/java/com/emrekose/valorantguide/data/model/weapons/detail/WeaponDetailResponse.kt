package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeaponDetailResponse(
    @Json(name = "data")
    val weaponDetails: Data?,
    @Json(name = "status")
    val status: Int?
)