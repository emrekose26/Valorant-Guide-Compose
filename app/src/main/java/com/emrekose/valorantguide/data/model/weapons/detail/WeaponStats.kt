package com.emrekose.valorantguide.data.model.weapons.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeaponStats(
    @Json(name = "adsStats")
    val adsStats: AdsStats?,
    @Json(name = "airBurstStats")
    val airBurstStats: Any?,
    @Json(name = "altFireType")
    val altFireType: String?,
    @Json(name = "altShotgunStats")
    val altShotgunStats: Any?,
    @Json(name = "damageRanges")
    val damageRanges: List<DamageRange?>?,
    @Json(name = "equipTimeSeconds")
    val equipTimeSeconds: Double?,
    @Json(name = "feature")
    val feature: String?,
    @Json(name = "fireMode")
    val fireMode: Any?,
    @Json(name = "fireRate")
    val fireRate: Double?,
    @Json(name = "firstBulletAccuracy")
    val firstBulletAccuracy: Double?,
    @Json(name = "magazineSize")
    val magazineSize: Int?,
    @Json(name = "reloadTimeSeconds")
    val reloadTimeSeconds: Double?,
    @Json(name = "runSpeedMultiplier")
    val runSpeedMultiplier: Double?,
    @Json(name = "shotgunPelletCount")
    val shotgunPelletCount: Int?,
    @Json(name = "wallPenetration")
    val wallPenetration: String?
)