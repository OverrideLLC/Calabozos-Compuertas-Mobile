package com.feature.dashboard.utils.routes

sealed class RoutesDrawer(val route: String) {
    data object Home : RoutesDrawer("home")
    data object Profile : RoutesDrawer("profile")
    data object Settings : RoutesDrawer("settings")
    data object Help : RoutesDrawer("help")
}