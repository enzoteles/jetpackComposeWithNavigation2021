package com.example.jetpackcompose2021.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose2021.ui.Tab1Screen
import com.example.jetpackcompose2021.ui.Tab2Screen
import com.example.jetpackcompose2021.ui.theme.TabLayoutColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Preview
@Composable
fun TabScreen() {
    val pageState = rememberPagerState(3)
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Tabs(pageState = pageState)
        TabContent( pageState = pageState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pageState: PagerState) {
    var list = listOf("Tab 1", "Tab 2")
    var scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pageState.currentPage,
        backgroundColor = TabLayoutColor,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 2.dp,
                color = Color.Green
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pageState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {

        list.forEachIndexed { index, _ ->

            Tab(
                text = {
                    Text(
                        list[index],
                        color = if(pageState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pageState.currentPage == index,
                onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(index)
                    }
                }
            )
        }

    }

}

@ExperimentalPagerApi
private @Composable
fun TabContent(pageState: PagerState) {
    HorizontalPager(state = pageState) { page ->
        when(page){
            0-> { Tab1Screen()
            }
            else -> { Tab2Screen()
            }
        }
    }
}