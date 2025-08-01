package tr.bay.kar.fi.ntech.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tr.bay.kar.fi.ntech.ui.screens.AboutScreen
import tr.bay.kar.fi.ntech.ui.screens.HomeScreen
import tr.bay.kar.fi.ntech.ui.screens.NoNetworkScreen
import tr.bay.kar.fi.ntech.ui.screens.SettingsScreen
import tr.bay.kar.fi.ntech.ui.screens.add_info.AddInfoScreen
import tr.bay.kar.fi.ntech.ui.screens.advice.AdviceScreen
import tr.bay.kar.fi.ntech.ui.screens.analytic.AnalyticsScreen
import tr.bay.kar.fi.ntech.ui.screens.content.ContentScreen
import tr.bay.kar.fi.ntech.ui.screens.history.HistoryScreen
import tr.bay.kar.fi.ntech.ui.screens.splash.SplashScreen
import tr.bay.kar.fi.ntech.ui.screens.unwatned_expenses.UnwantedExpensesScreen

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

        composable(route = ScreenRoutes.AdviceScreen.route) {
            AdviceScreen(navController, innerPadding)
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