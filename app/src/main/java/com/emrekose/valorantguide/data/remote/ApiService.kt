package com.emrekose.valorantguide.data.remote

import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import com.emrekose.valorantguide.data.model.maps.MapsResponse
import com.emrekose.valorantguide.data.model.weapons.WeaponsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("agents?isPlayableCharacter=true")
    suspend fun getAgents(): Response<AgentsResponse>

    @GET("maps")
    suspend fun getMaps(): Response<MapsResponse>

    @GET("weapons")
    suspend fun getWeapons(): Response<WeaponsResponse>
}