package com.feature.dashboard.utils.enums

import com.feature.dashboard.utils.routes.RoutesDrawer
import com.resources.Res
import com.resources.account_circle_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import com.resources.help_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import com.resources.home_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import com.resources.settings_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.DrawableResource

enum class ItemsDrawerEnum(
    val icon: DrawableResource,
    val title: String,
    val route: String
) {
    Home(
        icon = Res.drawable.home_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
        title = "Home",
        route = RoutesDrawer.Home.route
    ),
    Profile(
        icon = Res.drawable.account_circle_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
        title = "Profile",
        route = RoutesDrawer.Profile.route
    ),
    Settings(
        icon = Res.drawable.settings_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
        title = "Settings",
        route = RoutesDrawer.Settings.route
    ),
    Help(
        icon = Res.drawable.help_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
        title = "Help",
        route = RoutesDrawer.Help.route
    ),
}