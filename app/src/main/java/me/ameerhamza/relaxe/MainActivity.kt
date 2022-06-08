package me.ameerhamza.relaxe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.ameerhamza.relaxe.data.Feature
import me.ameerhamza.relaxe.data.FeatureParamType
import me.ameerhamza.relaxe.ui.screens.HomeScreen
import me.ameerhamza.relaxe.ui.screens.MeditationDetailScreen
import me.ameerhamza.relaxe.ui.screens.Screen
import me.ameerhamza.relaxe.ui.theme.RelaxeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelaxeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route){

                        composable(
                            route = Screen.HomeScreen.route,
//                            enterTransition = {slideInHorizontally(animationSpec = tween(500))},
//                            exitTransition = {slideOutHorizontally(animationSpec = tween(500))}
                        ) {
                            HomeScreen(navController)
                        }

                        composable(
                            route = Screen.MeditationDetailScreen.route + "/{featureJson}",
//                            enterTransition = {slideInHorizontally(animationSpec = tween(500))},
//                            exitTransition = {slideOutHorizontally(animationSpec = tween(500))},
                            arguments = listOf(
                                navArgument("featureJson") {
                                    type = FeatureParamType()
                                }
                            )
                        ) {
                            val feature = it.arguments?.getParcelable<Feature>("featureJson")
                            MeditationDetailScreen(feature)
                        }

                    }

                }
            }
        }

    }
}