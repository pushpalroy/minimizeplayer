package com.pushpal.minimizeplayer.ui

import androidx.constraintlayout.compose.ConstraintSet

fun getStartConstraint(): ConstraintSet {
  return ConstraintSet(
    """ {
                background: { 
                  width: "spread",
                  height: 70,
                  start: ['parent', 'start', 0],
                  bottom: ['parent', 'bottom', 0],
                  end: ['parent', 'end', 0]
                },
                v1: { 
                  width: 100,
                  height: 70,
                  start: ['parent', 'start', 0],
                  bottom: ['parent', 'bottom', 0]
                },
                title: { 
                  width: "spread",
                  start: ['v1', 'end', 16],
                  top: ['v1', 'top', 16],
                  end: ['parent', 'end', 8],
                  custom: {
                    textSize: 16
                  }
                },
                description: { 
                  start: ['v1', 'end',16],
                  top: ['title', 'bottom', 0],
                  custom: {
                    textSize: 14
                  }
                },
                list: { 
                  width: "spread",
                  height: 0,
                  start: ['parent', 'start', 8],
                  end: ['parent', 'end', 8],
                  top: ['parent', 'bottom', 0]
                },
                play: { 
                  end: ['close', 'start', 8],
                  top: ['v1', 'top', 0],
                  bottom: ['v1', 'bottom', 0]
                },
                close: { 
                  end: ['parent', 'end', 16],
                  top: ['v1', 'top', 0],
                  bottom: ['v1', 'bottom', 0]
                }
            } """
  )
}

fun getEndConstraintSet(): ConstraintSet {
  return ConstraintSet(
    """ {
                background: { 
                  width: "spread",
                  height: 250,
                  start: ['parent', 'start', 0],
                  end: ['parent', 'end', 0],
                  top: ['parent', 'top', 0]
                },
                v1: { 
                  width: "spread",
                  height: 250,
                  start: ['parent', 'start', 0],
                  end: ['parent', 'end', 0],
                  top: ['parent', 'top', 0]
                },
                title: { 
                  width: "spread",
                  height: 28,
                  start: ['parent', 'start', 16],
                  top: ['v1', 'bottom', 16],
                  end: ['parent', 'end', 16],
                  custom: {
                    textSize: 20
                  }
                },
                description: { 
                  width: "spread",
                  start: ['parent', 'start', 16],
                  top: ['title', 'bottom', 8],
                  end: ['parent', 'end', 16],
                  custom: {
                    textSize: 16
                  }
                },
                list: { 
                  width: "spread",
                  height: 400,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['description', 'bottom', 16],
                },
                play: { 
                  start: ['parent', 'end', 8],
                  top: ['v1', 'top', 0],
                  bottom: ['v1', 'bottom', 0]
                },
                close: { 
                  start: ['parent', 'end', 8],
                  top: ['v1', 'top', 0],
                  bottom: ['v1', 'bottom', 0]
                }
            } """
  )
}