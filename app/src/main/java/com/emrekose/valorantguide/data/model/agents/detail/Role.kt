package com.emrekose.valorantguide.data.model.agents.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Role(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "uuid")
    val uuid: String?
)