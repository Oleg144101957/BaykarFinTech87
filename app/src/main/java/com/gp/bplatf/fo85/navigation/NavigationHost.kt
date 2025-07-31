package com.gp.bplatf.fo85.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gp.bplatf.fo85.ui.screens.AboutScreen
import com.gp.bplatf.fo85.ui.screens.HomeScreen
import com.gp.bplatf.fo85.ui.screens.NoNetworkScreen
import com.gp.bplatf.fo85.ui.screens.SettingsScreen
import com.gp.bplatf.fo85.ui.screens.add_info.AddInfoScreen
import com.gp.bplatf.fo85.ui.screens.analytic.AnalyticsScreen
import com.gp.bplatf.fo85.ui.screens.content.ContentScreen
import com.gp.bplatf.fo85.ui.screens.history.HistoryScreen
import com.gp.bplatf.fo85.ui.screens.splash.SplashScreen
import com.gp.bplatf.fo85.ui.screens.unwatned_expenses.UnwantedExpensesScreen

@Composable
fun NavigationHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = ScreenRoutes.SplashScreen.route) {
        composable(route = ScreenRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = ScreenRoutes.HomeScreen.route) {
            HomeScreen(navController, innerPadding)
        }

        composable(route = ScreenRoutes.AboutScreen.route) {
            AboutScreen(navController, innerPadding)
        }

        composable(
            route = "${ScreenRoutes.ContentScreen.route}/{url}",
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            ContentScreen(navController, innerPadding, url)
        }

        composable(route = ScreenRoutes.NoNetworkScreen.route) {
            NoNetworkScreen(navController, innerPadding)
        }

        composable(route = ScreenRoutes.HistoryScreen.route) {
            HistoryScreen(navController)
        }

        composable(route = ScreenRoutes.AnalyticScreen.route) {
            AnalyticsScreen(navController)
        }

        composable(route = ScreenRoutes.SettingsScreen.route) {
            SettingsScreen(navController, innerPadding)
        }

        composable(route = ScreenRoutes.AddInfoScreen.route) {
            AddInfoScreen(navController)
        }

        composable(route = ScreenRoutes.UnwantedExpensesScreen.route) {
            UnwantedExpensesScreen(navController)
        }


    }
}