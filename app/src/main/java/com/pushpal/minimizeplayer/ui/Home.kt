package com.pushpal.minimizeplayer.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.pushpal.minimizeplayer.ui.theme.MinPlayerTheme
import com.pushpal.minimizeplayer.ui.timelines.BasicTimeLine

@Composable
fun HomeScreen() {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = { HomeAppBar(backgroundColor = MinPlayerTheme.colors.uiBorder) }
  ) {
    HomeContent(
      modifier = Modifier.fillMaxSize()
    )
  }
}

@OptIn(
  ExperimentalMaterialApi::class,
  ExperimentalAnimationApi::class
)
@Composable
fun HomeContent(
  modifier: Modifier = Modifier
) {
  val tabs = remember { listOf("Draggable Player") }
  var selectedIndex by remember { mutableStateOf(0) }
  Column(modifier = modifier) {
    ScrollableTabRow(
      backgroundColor = MinPlayerTheme.colors.uiBorder,
      contentColor = MinPlayerTheme.colors.accent,
      selectedTabIndex = selectedIndex,
      edgePadding = 0.dp
    ) {
      tabs.forEachIndexed { index, title ->
        Tab(
          selected = index == selectedIndex,
          selectedContentColor = MinPlayerTheme.colors.uiBackground,
          onClick = { selectedIndex = tabs.indexOf(title) },
          text = {
            Text(
              text = title,
              color = MinPlayerTheme.colors.buttonTextColor
            )
          }
        )
      }
    }

    when (selectedIndex) {
      0 -> BasicTimeLine()
    }
  }
}

@Composable
fun HomeAppBar(
  backgroundColor: Color,
  modifier: Modifier = Modifier
) {
  TopAppBar(
    title = {
      Text(
        text = "MinPlayer Samples",
        color = MinPlayerTheme.colors.textSecondaryDark
      )
    },
    backgroundColor = backgroundColor,
    modifier = modifier
  )
}

@Preview("Preview HomeScreen")
@Composable
fun PreviewHomeScreen() {
  HomeScreen()
}