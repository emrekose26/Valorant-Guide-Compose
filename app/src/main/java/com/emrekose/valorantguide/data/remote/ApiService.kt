package com.emrekose.valorantguide.data.remote

import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import com.emrekose.valorantguide.data.model.agents.detail.AgentDetailResponse
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import com.emrekose.valorantguide.data.model.maps.detail.MapDetailResponse
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import com.emrekose.valorantguide.data.model.weapons.detail.WeaponDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("agents?isPlayableCharacter=true")
    suspend fun getAgents(): Response<AgentsResponse>

    @GET("agents/{agentUuid}")
    suspend fun getAgentDetail(@Path("agentUuid") agentUuid: String): Response<AgentDetailResponse>

    @GET("maps")
    suspend fun getMaps(): Response<MapsResponse>

    @GET("maps/{mapUuid}")
    suspend fun getMapDetail(@Path("mapUuid") mapUuid: String): Response<MapDetailResponse>

    @GET("weapons")
    suspend fun getWeapons(): Response<WeaponsResponse>

    @GET("weapons/{weaponUuid}")
    suspend fun getWeaponDetail(@Path("weaponUuid") weaponUuid: String): Response<WeaponDetailResponse>
}