package com.emrekose.valorantguide.features.agents.detail.domain.model

import com.emrekose.valorantguide.data.model.agents.detail.Ability
import com.emrekose.valorantguide.data.model.agents.detail.Role
import com.emrekose.valorantguide.data.model.agents.detail.VoiceLine

data class AgentDetailUiModel(
    val abilities: List<Ability?>?,
    val background: String?,
    val fullPortrait: String?,
    val fullPortraitV2: String?,
    val description: String?,
    val displayName: String?,
    val role: Role?,
    val uuid: String?,
    val voiceLine: VoiceLine?
)
