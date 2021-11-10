package com.example.jetpack_navigation

import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
internal fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen{ nameScreen->
                navController.navigate(nameScreen)
            }
        }
        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "Enzo"
                nullable = true
            }
        )){ entry->
            DetailScreen(name = entry?.arguments?.getString("name") ?: "")
        }
    }
}

@Composable
fun MainScreen(
    nameScreen: (String) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    )
    {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            nameScreen(Screen.DetailScreen.route)
        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Detail Screen")
        }
    }
}


@Composable
fun DetailScreen(
    name: String
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello, $name")
    }
}