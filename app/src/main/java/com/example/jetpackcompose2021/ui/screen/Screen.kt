package com.example.jetpackcompose2021.ui.screen

import androidx.annotation.StringRes

sealed class Screen(val route:String){
    object ListCommicsScreen: Screen(route = "list_screen")
    object CommicsDetailScreen: Screen(route = "detail_screen")
}
