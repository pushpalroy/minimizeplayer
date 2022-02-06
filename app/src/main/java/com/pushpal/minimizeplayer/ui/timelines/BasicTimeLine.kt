package com.pushpal.minimizeplayer.ui.timelines

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pushpal.minimizeplayer.ui.PlayerView
import com.pushpal.minimizeplayer.ui.theme.MinPlayerSurface
import com.pushpal.minimizeplayer.ui.theme.MinPlayerTheme

@ExperimentalAnimationApi
@Composable
fun BasicTimeLine() {
  MinPlayerSurface(
    color = MinPlayerTheme.colors.uiBackground,
    modifier = Modifier
      .fillMaxSize()
  ) {
    PlayerView()
  }
}

@ExperimentalAnimationApi
@Preview("Preview Basic TimeLine")
@Composable
fun PreviewBasicTimeLine() {
  BasicTimeLine()
}