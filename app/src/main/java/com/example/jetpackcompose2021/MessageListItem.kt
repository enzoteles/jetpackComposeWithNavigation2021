package com.example.jetpackcompose2021

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MessageListItem (
    item: Message,
    onClick: (Message)-> Unit
){
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(item) })
    ){
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = item.author,
                    style = MaterialTheme.typography.subtitle2,

                    )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.body,
                    style = MaterialTheme.typography.body2
                )
            }

        }
        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f))
    }
}


