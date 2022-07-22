package com.emrekose.valorantguide.features.agents.listing.domain.model

import com.emrekose.valorantguide.data.model.agents.Ability
import com.emrekose.valorantguide.data.model.agents.Role
import com.emrekose.valorantguide.data.model.agents.VoiceLine

data class AgentsUiModel(
    val abilities: List<Ability?>?,
    val background: String?,
    val bustPortrait: String?,
    val description: String?,
    val displayName: String?,
    val fullPortrait: String?,
    val fullPortraitV2: String?,
    val role: Role?,
    val uuid: String?,
    val voiceLine: VoiceLine?
)
