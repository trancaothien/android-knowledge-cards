package com.studio35.knowledgecards.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.studio35.knowledgecards.ui.base.BaseDestination
import com.studio35.knowledgecards.ui.screens.main.mainNavGraph
import timber.log.Timber

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        route = AppDestination.RootNavGraph.route,
        startDestination = AppDestination.MainNavGraph.destination
    ) {
        mainNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.composable(
    destination: BaseDestination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = destination.route,
        arguments = destination.arguments,
        deepLinks = destination.deepLinks.map {
            navDeepLink {
                uriPattern = it
            }
        },
        content = content
    )
}

fun NavHostController.go(destination: BaseDestination) {
    Timber.i("\nNAVIGATION")
    Timber.i("NAVIGATION Destination: ${destination.destination}")
    Timber.i("NAVIGATION Arguments: ${destination.arguments}")
    when (destination) {
        is BaseDestination.Up -> {
            Timber.i("NAVIGATION Result: ${destination.results}")
            destination.results.forEach { (key, value) ->
                previousBackStackEntry?.savedStateHandle?.set(key, value)
            }
            navigateUp()
        }
        else -> navigate(route = destination.destination)
    }
}
