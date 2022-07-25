package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShopData(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "canBeTrashed")
    val canBeTrashed: Boolean?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "categoryText")
    val categoryText: String?,
    @Json(name = "cost")
    val cost: Int?,
    @Json(name = "gridPosition")
    val gridPosition: GridPosition?,
    @Json(name = "image")
    val image: Any?,
    @Json(name = "newImage")
    val newImage: String?,
    @Json(name = "newImage2")
    val newImage2: Any?
)