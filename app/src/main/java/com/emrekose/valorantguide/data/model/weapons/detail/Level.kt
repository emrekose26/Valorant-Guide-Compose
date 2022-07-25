package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Level(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "levelItem")
    val levelItem: String?,
    @Json(name = "streamedVideo")
    val streamedVideo: String?,
    @Json(name = "uuid")
    val uuid: String?
)