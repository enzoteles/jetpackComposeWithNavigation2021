package com.example.jetpackcompose2021.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose2021.DetailCharacter
import com.example.jetpackcompose2021.ListCharacter

@Composable
internal fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListCommicsScreen.route) {
        val listMessage = listOf(
            Message("Enzo", "Teles"),
            Message("Dani", "Teles"),
            Message("Agatha", "Teles"),
            Message("Sophia", "Teles"),
            Message("Julhia", "Teles"),
            Message("Enzo", "Teles"),
            Message("Dani", "Teles"),
            Message("Agatha", "Teles"),
            Message("Sophia", "Teles"),
            Message("Julhia", "Teles"),
            Message("Enzo", "Teles"),
            Message("Dani", "Teles"),
            Message("Agatha", "Teles"),
            Message("Sophia", "Teles"),
            Message("Julhia", "Teles"),
            Message("Enzo", "Teles"),
            Message("Dani", "Teles"),
            Message("Agatha", "Teles"),
            Message("Sophia", "Teles"),
            Message("Julhia", "Teles"),
            Message("Enzo", "Teles"),
            Message("Dani", "Teles"),
            Message("Agatha", "Teles"),
            Message("Sophia", "Teles"),
            Message("Julhia", "Teles")
        )
        composable(route = Screen.ListCommicsScreen.route) {
            ListCharacter(listMessage){ nameScreen->
                navController.navigate(nameScreen)
            }
        }
        composable(
            route = Screen.CommicsDetailScreen.route + "/{index}",
            arguments = listOf(
                navArgument("index"){
                    type = NavType.IntType
                }
            )
        ){ entry->
            val index = entry.arguments?.getInt("index") ?: 0
            val msg = listMessage[index]
            DetailCharacter(msg = msg){
                navController.popBackStack()
            }
        }
    }
}