package com.boolder.boolderflo.utils.previewgenerator

import com.boolder.boolderflo.domain.model.ProblemWithLine

fun dummyProblemWithLine(
    id: Int = 1000,
    name: String = "The dummy problem"
) = ProblemWithLine(
    problem = dummyProblem(id = id, name = name),
    line = dummyLine()
)
