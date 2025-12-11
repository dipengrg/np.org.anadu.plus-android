package np.org.anadu.plus.ui.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import np.org.anadu.plus.ui.auth.PhoneVerificationScreen

@Composable
fun Route(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        composable("auth") {
            PhoneVerificationScreen()
        }

        composable("loading") {
            LoadingScreen()
        }
    }
}