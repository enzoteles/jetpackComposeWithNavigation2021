package com.example.jetpackcompose2021.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun Tab1Screen(){
    Text(
        modifier = Modifier.fillMaxSize(),
        fontSize = 24.sp,
        text = "Tab 1 Screen"
    )
}