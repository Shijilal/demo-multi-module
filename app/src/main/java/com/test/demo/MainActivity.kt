package com.test.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.demo.navigation.Screens
import com.test.demo.ui.theme.DemoTheme
import com.test.login.ui.LoginScreen
import com.test.login.ui.SplashScreen
import com.test.login.ui.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
               val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screens.Splash.route,
                    builder = {
                        addSplashScreen(
                            navController = navController
                        )
                        addLoginScreen(
                            navController = navController
                        )
                    }
                )
            }
        }
    }
}

fun NavGraphBuilder.addSplashScreen(
    navController: NavController
){
    composable(
        route = Screens.Splash.route
    ){
        val viewModel: SplashViewModel = hiltViewModel()
        SplashScreen(
            delayTime = 3000L
        ) {
            navController.navigate(Screens.Login.route) {
                popUpTo(Screens.Splash.route) {
                    inclusive = true
                }
            }
        }
    }

}

fun NavGraphBuilder.addLoginScreen(
    navController: NavController
) {
    composable(
        route = Screens.Login.route
    ) {
        LoginScreen()
    }
}