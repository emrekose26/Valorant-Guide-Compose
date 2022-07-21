package com.emrekose.valorantguide.data.model.weapons


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Skin(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "chromas")
    val chromas: List<Chroma?>?,
    @Json(name = "contentTierUuid")
    val contentTierUuid: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "levels")
    val levels: List<Level?>?,
    @Json(name = "themeUuid")
    val themeUuid: String?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "wallpaper")
    val wallpaper: String?
)