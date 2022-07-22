package com.emrekose.valorantguide.ui.navigation

import com.emrekose.valorantguide.R

sealed class ScreenType(
    val route: String,
    val icon: Int?,
    val name: String?
) {
    object Agents : ScreenType("agents", R.drawable.ic_supervised_user_circle, "Agents")
    object AgentDetail : ScreenType("agentDetail", null, null)
    object Maps : ScreenType("maps", R.drawable.ic_baseline_map, "Maps")
    object MapDetail: ScreenType("mapDetail", null, null)
    object Weapons : ScreenType("weapons", R.drawable.ic_weapons, "Weapons")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}