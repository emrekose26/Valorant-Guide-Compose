package com.emrekose.valorantguide.features.agents.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.agents.AgentsResponse
import com.emrekose.valorantguide.features.agents.domain.model.AgentsUiModel
import javax.inject.Inject

class AgentsMapper @Inject constructor()
    : Mapper<AgentsResponse?, List<AgentsUiModel>?> {

    override fun mapFrom(from: AgentsResponse?): List<AgentsUiModel>? {
        return from?.agentsData?.map { agent ->
            AgentsUiModel(
                abilities = agent?.abilities,
                background = agent?.background,
                description = agent?.description,
                displayName = agent?.displayName,
                fullPortrait = agent?.fullPortrait,
                fullPortraitV2 = agent?.fullPortraitV2,
                role = agent?.role,
                uuid = agent?.uuid,
                voiceLine = agent?.voiceLine
            )
        }
    }
}