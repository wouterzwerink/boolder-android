package com.boolder.boolderflo.utils.previewgenerator

import com.boolder.boolderflo.domain.model.CircuitColor
import com.boolder.boolderflo.view.detail.uimodel.ProblemStart

fun dummyProblemStart(
    x: Int,
    y: Int
) = ProblemStart(
    x = x,
    y = y,
    dpSize = 28,
    colorRes = CircuitColor.RED.colorRes,
    textColorRes = android.R.color.white
)
