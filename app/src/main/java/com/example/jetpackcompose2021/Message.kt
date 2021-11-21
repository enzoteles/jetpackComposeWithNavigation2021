package com.example.jetpackcompose2021

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(val author:String, val body: String): Parcelable