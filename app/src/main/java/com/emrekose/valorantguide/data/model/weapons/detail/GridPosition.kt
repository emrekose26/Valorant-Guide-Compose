package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GridPosition(
    @Json(name = "column")
    val column: Int?,
    @Json(name = "row")
    val row: Int?
)