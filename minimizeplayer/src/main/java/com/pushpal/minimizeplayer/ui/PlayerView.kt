package com.pushpal.minimizeplayer.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.layoutId

@OptIn(ExperimentalMotionApi::class)
@Composable
fun PlayerView() {
  var animateToEnd by remember { mutableStateOf(false) }
  val progress by animateFloatAsState(
    targetValue = if (animateToEnd) 1f else 0f,
    // animationSpec = spring(
    //   dampingRatio = 0.4f,
    //   stiffness = 200f
    // )
    animationSpec = tween(
      delayMillis = 100,
      durationMillis = 600,
      easing = LinearOutSlowInEasing
    )
  )

  BackHandler(enabled = animateToEnd) {
    animateToEnd = animateToEnd.not()
  }

  Column(
    Modifier.background(
      color = Color(0xFF263646)
    )
  ) {
    MotionLayout(
      start = getStartConstraint(),
      end = getEndConstraintSet(),
      progress = progress,
      modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF8A9CAF))
    ) {
      Box(
        modifier = Modifier
          .layoutId("background", "box")
          .background(Color(0xFF263646))
          .clickable(onClick = { animateToEnd = !animateToEnd })
      )

      Box(
        modifier = Modifier
          .layoutId("v1", "box")
          .background(Color(0xFF3D6996))
          .clickable(onClick = { animateToEnd = !animateToEnd })
      )

      Text(
        text = "Wish You Were Here",
        modifier = Modifier.layoutId("title"),
        color = Color(0xFFF3F3F3),
        fontSize = motionProperties("title").value.fontSize("textSize")
      )

      Text(
        text = "Pink Floyd",
        modifier = Modifier.layoutId("description"),
        color = Color(0xffdadce0),
        fontSize = motionProperties("description").value.fontSize("textSize")
      )

      Box(
        modifier = Modifier
          .layoutId("list", "box")
          .background(Color(0xFF1A3652))
      )

      Icon(
        Filled.PlayArrow,
        contentDescription = "Play",
        tint = Color.White,
        modifier = Modifier.layoutId("play")
      )

      Icon(
        Filled.Close,
        contentDescription = "Close",
        tint = Color.White,
        modifier = Modifier.layoutId("close")
      )
    }
  }
}