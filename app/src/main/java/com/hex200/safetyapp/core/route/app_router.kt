package com.hex200.safetyapp.core.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hex200.safetyapp.BottomNavigationPageView
import com.hex200.safetyapp.EditProfile
import com.hex200.safetyapp.SosCustomization

enum class Routes {
    ROOT,
    EDIT_PROFILE,
    SOS_CUSTOMIZATION,

}

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(
        navController=navController,
        startDestination = Routes.ROOT.toString()
    ){
        composable(Routes.ROOT.toString()) {
            BottomNavigationPageView(navController)
        }
        composable(Routes.EDIT_PROFILE.toString()) {
            EditProfile(navController)
        }
        composable(Routes.SOS_CUSTOMIZATION.toString()) {
            SosCustomization(navController)
        }


    }
}