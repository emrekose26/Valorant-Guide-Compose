package com.emrekose.valorantguide.di

import com.emrekose.valorantguide.data.remote.ApiService
import com.emrekose.valorantguide.data.repository.AgentsRepositoryImp
import com.emrekose.valorantguide.features.agents.domain.repository.AgentsRepository
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
}