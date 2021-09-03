package com.test.demo.navigation

import androidx.navigation.compose.NamedNavArgument

sealed class Screens(
    val route: String,
    val argument: List<NamedNavArgument>
) {
    object Splash : Screens(
        route = "splash",
        argument = emptyList()
    )
    object Login : Screens(
        route = "login",
        argument = emptyList()
    )
}
