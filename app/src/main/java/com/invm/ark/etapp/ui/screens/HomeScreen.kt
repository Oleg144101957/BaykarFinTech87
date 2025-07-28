package com.invm.ark.etapp.ui.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.invm.ark.etapp.R
import com.invm.ark.etapp.navigation.ScreenRoutes
import com.invm.ark.etapp.ui.elements.Background
import com.invm.ark.etapp.ui.elements.GreenButton
import com.invm.ark.etapp.util.lockOrientation

@Composable
fun HomeScreen(navController: NavHostController, innerPadding: PaddingValues) {

    val context = LocalContext.current
    val activity = context as? Activity
    activity?.lockOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    BackHandler { }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Background()
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))
            Image(
                painterResource(R.drawable.logo),
                R.drawable.logo.toString(),
                modifier = Modifier.fillMaxWidth(0.3f),
                contentScale = ContentScale.FillWidth
            )
            Spacer(Modifier.height(32.dp))
            Menu(navController)
        }
    }
}

@Composable
fun Menu(navController: NavHostController) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GreenButton(R.string.add_info, modifier = Modifier) {
            navController.navigate(ScreenRoutes.AddInfoScreen.route)
        }

        Spacer(modifier = Modifier.height(16.dp))
        GreenButton(R.string.history, modifier = Modifier) {
            navController.navigate(ScreenRoutes.HistoryScreen.route)
        }

        Spacer(modifier = Modifier.height(16.dp))
        GreenButton(R.string.analytic, modifier = Modifier) {
            navController.navigate(ScreenRoutes.AnalyticScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        GreenButton(R.string.settings, modifier = Modifier) {
            navController.navigate(ScreenRoutes.SettingsScreen.route)
        }
    }
}
