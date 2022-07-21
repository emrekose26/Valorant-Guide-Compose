package com.emrekose.valorantguide.data.model.weapons


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Chroma(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "fullRender")
    val fullRender: String?,
    @Json(name = "streamedVideo")
    val streamedVideo: String?,
    @Json(name = "swatch")
    val swatch: String?,
    @Json(name = "uuid")
    val uuid: String?
)