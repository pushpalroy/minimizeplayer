package com.pushpal.minimizeplayer.ui.util.multifab

import androidx.compose.ui.graphics.vector.ImageVector

data class MultiFabItem(
  val id: Int,
  val iconRes: ImageVector,
  val label: String = ""
)