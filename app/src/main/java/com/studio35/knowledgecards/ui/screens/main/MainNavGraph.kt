package com.studio35.knowledgecards.ui.screens.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.studio35.knowledgecards.ui.AppDestination
import com.studio35.knowledgecards.ui.composable
import com.studio35.knowledgecards.ui.go
import com.studio35.knowledgecards.ui.screens.main.home.HomeScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = AppDestination.MainNavGraph.route,
        startDestination = MainDestination.Home.destination
    ) {
        composable(MainDestination.Home) {
            HomeScreen(
                navigator = { destination -> navController.go(destination) }
            )
        }
    }
}
