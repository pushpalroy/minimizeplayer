package com.pushpal.minimizeplayer.ui.timelines

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pushpal.minimizeplayer.data.FakeData
import com.pushpal.minimizeplayer.data.JetLimeItemsModel
import com.pushpal.minimizeplayer.data.config.JetLimeViewConfig
import com.pushpal.minimizeplayer.data.config.LineType
import com.pushpal.minimizeplayer.ui.JetLimeView
import com.pushpal.minimizeplayer.ui.theme.JetLimeSurface
import com.pushpal.minimizeplayer.ui.theme.JetLimeTheme

@ExperimentalAnimationApi
@Composable
fun BasicTimeLine() {
  val jetLimeItemsModel = remember { JetLimeItemsModel(list = FakeData.simpleJetLimeItems) }
  val listState = rememberLazyListState()
  val jetTimeLineViewConfig = JetLimeViewConfig(
    backgroundColor = JetLimeTheme.colors.uiBackground,
    itemSpacing = 0.dp,
    lineType = LineType.Solid,
    enableItemAnimation = false,
    showIcons = true
  )

  JetLimeSurface(
    color = JetLimeTheme.colors.uiBackground,
    modifier = Modifier
      .fillMaxSize()
  ) {
    JetLimeView(
      jetLimeItemsModel = jetLimeItemsModel,
      jetLimeViewConfig = jetTimeLineViewConfig,
      listState = listState,
      modifier = Modifier.padding(16.dp)
    )
  }
}

@ExperimentalAnimationApi
@Preview("Preview Basic TimeLine")
@Composable
fun PreviewBasicTimeLine() {
  BasicTimeLine()
}