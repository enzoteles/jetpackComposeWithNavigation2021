package com.example.jetpackcompose2021

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose2021.ui.screen.DetailScreen
import com.example.jetpackcompose2021.ui.screen.ListScreen
import com.example.jetpackcompose2021.ui.screen.Screen
import com.example.jetpackcompose2021.ui.theme.JetPackCompose2021Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCompose2021Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

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
            ListScreen(listMessage){ nameScreen->
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
            DetailScreen(msg = msg)
        }
    }
}