package tr.ba.y.kar.fi.ui.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import tr.ba.y.kar.fi.R
import tr.ba.y.kar.fi.navigation.ScreenRoutes
import tr.ba.y.kar.fi.ui.elements.Background
import tr.ba.y.kar.fi.ui.elements.GreenButton
import tr.ba.y.kar.fi.util.lockOrientation

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

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.menu_anim))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )


    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GreenButton(
                R.string.add_info,
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            ) {
                navController.navigate(ScreenRoutes.AddInfoScreen.route)
            }

            GreenButton(
                R.string.history,
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            ) {
                navController.navigate(ScreenRoutes.HistoryScreen.route)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Второй ряд кнопок
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GreenButton(
                R.string.analytic,
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            ) {
                navController.navigate(ScreenRoutes.AnalyticScreen.route)
            }

            GreenButton(
                R.string.settings,
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            ) {
                navController.navigate(ScreenRoutes.SettingsScreen.route)
            }
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}
