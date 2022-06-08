package me.ameerhamza.relaxe.ui.screens

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object MeditationDetailScreen: Screen("meditation_detail_screen")
}