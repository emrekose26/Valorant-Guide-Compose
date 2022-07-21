package com.emrekose.valorantguide.data.model.agents


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "wave")
    val wave: String?,
    @Json(name = "wwise")
    val wwise: String?
)