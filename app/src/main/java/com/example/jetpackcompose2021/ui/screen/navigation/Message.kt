package com.example.jetpackcompose2021.ui.screen.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(val author:String, val body: String): Parcelable