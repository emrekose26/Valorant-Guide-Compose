package com.emrekose.valorantguide.di

import com.emrekose.valorantguide.data.remote.ApiService
import com.emrekose.valorantguide.data.repository.AgentsRepositoryImp
import com.emrekose.valorantguide.data.repository.MapsRepositoryImp
import com.emrekose.valorantguide.data.repository.WeaponsRepositoryImp
import com.emrekose.valorantguide.features.agents.domain.repository.AgentsRepository
import com.emrekose.valorantguide.features.maps.listing.domain.repository.MapsRepository
import com.emrekose.valorantguide.features.weapons.listing.domain.repository.WeaponsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideAgentsRepository(apiService: ApiService): AgentsRepository =
        AgentsRepositoryImp(apiService)

    @Provides
    fun provideMapsRepository(apiService: ApiService): MapsRepository =
        MapsRepositoryImp(apiService)

    @Provides
    fun provideWeaponsRepository(apiService: ApiService): WeaponsRepository =
        WeaponsRepositoryImp(apiService)
}