package com.example.jetpack_navigation

import androidx.annotation.StringRes

sealed class Screen(val route:String, @StringRes val resourceId:Int){
    object MainScreen: Screen(route = "main", resourceId = R.string.main_screen)
    object DetailScreen: Screen(route = "detail", resourceId = R.string.detail_screen)
}
