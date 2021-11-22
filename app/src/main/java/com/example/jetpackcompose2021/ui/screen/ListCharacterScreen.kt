package com.example.jetpackcompose2021

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose2021.ui.screen.Screen

@Composable
fun ListCharacter(
    listMsg: List<Message>,
    nameScreen: (String)-> Unit
){
    Scaffold(
        topBar = { TopBarListCharacter() },
        content = { ListLazyCollun(listMsg = listMsg, nameScreen = nameScreen) },
    )

}

@Composable
fun TopBarListCharacter(){
    TopAppBar(
        title = {
            Text(text = "List of Characters")
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun ListLazyCollun(
    listMsg: List<Message>,
    nameScreen: (String)-> Unit
){
    LazyColumn{
        itemsIndexed(
            listMsg
        ){ index, item ->
            // layout msgs
            MessageListItem(item = item, onClick = {
                nameScreen(Screen.CommicsDetailScreen.route + "/$index")
            })
        }
    }
}