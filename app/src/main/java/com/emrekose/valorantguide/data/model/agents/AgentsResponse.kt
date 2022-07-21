package com.emrekose.valorantguide.data.model.agents


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgentsResponse(
    @Json(name = "data")
    val `data`: List<Data?>?,
    @Json(name = "status")
    val status: Int?
)