package com.emrekose.valorantguide.data.model.maps.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "callouts")
    val callouts: List<Callout?>?,
    @Json(name = "coordinates")
    val coordinates: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "listViewIcon")
    val listViewIcon: String?,
    @Json(name = "mapUrl")
    val mapUrl: String?,
    @Json(name = "splash")
    val splash: String?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "xMultiplier")
    val xMultiplier: Double?,
    @Json(name = "xScalarToAdd")
    val xScalarToAdd: Double?,
    @Json(name = "yMultiplier")
    val yMultiplier: Double?,
    @Json(name = "yScalarToAdd")
    val yScalarToAdd: Double?
)