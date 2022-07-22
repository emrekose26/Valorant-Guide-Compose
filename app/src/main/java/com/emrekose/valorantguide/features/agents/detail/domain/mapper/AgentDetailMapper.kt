package com.emrekose.valorantguide.features.agents.detail.domain.mapper

import com.emrekose.valorantguide.common.base.Mapper
import com.emrekose.valorantguide.data.model.agents.detail.AgentDetailResponse
import com.emrekose.valorantguide.features.agents.detail.domain.model.AgentDetailUiModel
import javax.inject.Inject

class AgentDetailMapper @Inject constructor(): Mapper<AgentDetailResponse?, AgentDetailUiModel> {

    override fun mapFrom(from: AgentDetailResponse?): AgentDetailUiModel {
        return AgentDetailUiModel(
            abilities = from?.agentDetails?.abilities,
            background = from?.agentDetails?.background,
            fullPortrait = from?.agentDetails?.fullPortrait,
            fullPortraitV2 = from?.agentDetails?.fullPortraitV2,
            description = from?.agentDetails?.description,
            displayName = from?.agentDetails?.displayName,
            role = from?.agentDetails?.role,
            uuid = from?.agentDetails?.uuid,
            voiceLine = from?.agentDetails?.voiceLine
        )
    }
}