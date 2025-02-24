package com.controller

data class ControllerState(
    var indexActual: Int = 0,
    var directionNavigation: Boolean = false,
    var isPagComplete: Boolean = true,
    var isLoading: Boolean = true,
    var p: String = ""
)