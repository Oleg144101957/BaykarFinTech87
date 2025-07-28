package com.invm.ark.etapp.ui.screens.splash

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.invm.ark.etapp.R
import com.invm.ark.etapp.domain.grey.LoadingState
import com.invm.ark.etapp.navigation.ScreenRoutes
import com.invm.ark.etapp.ui.elements.Background
import com.invm.ark.etapp.util.lockOrientation
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    BackHandler { }

    val state = splashViewModel.liveState.collectAsState().value
    val context = LocalContext.current
    val activity = context as? Activity
    activity?.lockOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val permission = android.Manifest.permission.POST_NOTIFICATIONS
    val permissionState = remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionState.value = isGranted
        splashViewModel.updatePermissionState(isGranted)
    }

    // Запрос разрешения
    LaunchedEffect(Unit) {
        launcher.launch(permission)
    }

    // Навигация в зависимости от состояния
    LaunchedEffect(state) {
        when (state) {
            LoadingState.InitState -> {
                splashViewModel.getState(context)
            }

            is LoadingState.ContentState -> {
                val url = URLEncoder.encode(state.url, StandardCharsets.UTF_8.toString())
                val route = "${ScreenRoutes.ContentScreen.route}/$url"
                navController.navigate(route)
            }

            LoadingState.NoNetworkState -> {
                navController.navigate(ScreenRoutes.NoNetworkScreen.route)
            }

            LoadingState.WhiteState -> {
                navController.navigate(ScreenRoutes.HomeScreen.route)
            }
        }
    }

    // UI
    Box(modifier = Modifier.fillMaxSize()) {
        Background(R.drawable.loading_bg)

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
            val progress by animateLottieCompositionAsState(
                composition,
                iterations = LottieConstants.IterateForever
            )

            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


