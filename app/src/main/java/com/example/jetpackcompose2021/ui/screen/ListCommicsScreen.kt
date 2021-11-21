package com.example.jetpackcompose2021.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose2021.Message
import com.example.jetpackcompose2021.MessageListItem


@Composable
fun ListScreen(
    listMsg: List<Message>,
    nameScreen: (String)-> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .height(45.dp)
                    .background(Color.Blue),

            ) {
                Text(
                    text = "Lista de Mensagens",
                    fontSize= 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }     
        },
        content = {
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
    )

}


@Composable
fun DetailScreen(
    msg: Message
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello, ${msg.author}")
    }
}