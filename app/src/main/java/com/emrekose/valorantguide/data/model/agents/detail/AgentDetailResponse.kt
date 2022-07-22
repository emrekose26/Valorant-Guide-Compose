package com.emrekose.valorantguide.data.model.agents.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgentDetailResponse(
    @Json(name = "data")
    val agentDetails: Data?,
    @Json(name = "status")
    val status: Int?
)